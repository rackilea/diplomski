public class MainActivity extends AppCompatActivity {

// this is the action code we use in our intent,
// this way we know we're looking at the response from our own action
private static final int SELECT_SINGLE_PICTURE = 101;

private static final int CAMERA_REQUEST = 102;

public static final String IMAGE_TYPE = "image/*";

private final int RequestCode = 20;

Uri mImageCaptureUri1;

/* Get the reference to the text label */
TextView label = null;

ImageView selectedImagePreview;
ImageView imageViewFace;



void showImage(Bitmap image)
{
    imageViewFace.setImageBitmap(null);
    FaceCropper mFaceCropper = new FaceCropper();
    mFaceCropper.setMaxFaces(1);
    mFaceCropper.setEyeDistanceFactorMargin(0);
    image = mFaceCropper.getCroppedImage(image);

    String faceFound;
    if (mFaceCropper.faceDetected==true){
        faceFound = "Face Detected!";
    }else faceFound ="No face detected!";

    /* Get the starting time */
    long startTime = 0;

    startTime = System.nanoTime();

    /* Get the image statistics */
    ImageStats imageStats = new ImageStats(image);

    System.out.println("Execution time: " + (((double)(System.nanoTime() - startTime))/1000000000.0) + " seconds!");

     /* Get the image statistics */
    double[] stats = imageStats.getStats();

    /*  Decide whether or not the image is of good quality */
    String results = imageStats.result;


     /* Create the labels */
    String[] labels = new String[]{"Standard Luminosity: ", "Contrast: ", "Face orientation: ", "Sharpness: "};

     /* The string of statistics */
    StringBuffer strStatsBuff = new StringBuffer();

     /* Go through all the statistics */
    for(int statIndex = 0; statIndex < stats.length; ++statIndex)
    {
          /* Add the statistics */
        strStatsBuff.append(labels[statIndex]);
        strStatsBuff.append(String.valueOf(stats[statIndex]));
        strStatsBuff.append("\n");
    }

     /* Add the file name */
   strStatsBuff.append(faceFound);


      /* Set the label and show the cropped image */
    label.setText(strStatsBuff.toString());


    if (mFaceCropper.faceDetected == true)
    {
        imageViewFace.setImageBitmap(image);

    }

}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // no need to cast to button view here since we can add a listener to any view, this
    // is the single image selection
    label = (TextView)findViewById(R.id.label);



    findViewById(R.id.buttonGallery).setOnClickListener(new View.OnClickListener() {
        public void onClick(View arg0) {

            // in onCreate or any event where your want the user to
            // select a file
            Intent intent = new Intent();
            intent.setType(IMAGE_TYPE);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,
                    "Select image"), SELECT_SINGLE_PICTURE);
        }
    });

    findViewById(R.id.buttonCamera).setOnClickListener(new View.OnClickListener(){
        public void onClick(View arg0 ){
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            mImageCaptureUri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                    "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));

            cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri1);
            cameraIntent.putExtra("return-data", true);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    });

    selectedImagePreview = (ImageView)findViewById(R.id.imageView1);
    imageViewFace = (ImageView)findViewById(R.id.imageViewFace);
}

public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        if (requestCode == SELECT_SINGLE_PICTURE) {

            Uri selectedImageUri = data.getData();

            try {
                Bitmap bitmap;
                selectedImagePreview.setImageBitmap(new UserPicture(selectedImageUri, getContentResolver()).getBitmap());
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImageUri));
                selectedImagePreview.setImageBitmap(bitmap);

                showImage(bitmap);

            } catch (IOException e) {
                Log.e(MainActivity.class.getSimpleName(), "Failed to load image", e);
                e.printStackTrace();
            }

        }
        else if (requestCode==CAMERA_REQUEST){

            try {
                Bitmap bitmap;
                selectedImagePreview.setImageBitmap(new UserPicture(mImageCaptureUri1, getContentResolver()).getBitmap());
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(mImageCaptureUri1));
                selectedImagePreview.setImageBitmap(bitmap);
                String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());


                showImage(bitmap);

            } catch (IOException e) {
                Log.e(MainActivity.class.getSimpleName(), "Failed to load image", e);
                e.printStackTrace();
            }



        }

    }



    else {
        // report failure
        Toast.makeText(getApplicationContext(),"failed to get intent data", Toast.LENGTH_LONG).show();
        Log.d(MainActivity.class.getSimpleName(), "Failed to get intent data, result code is " + resultCode);
    }
}
}