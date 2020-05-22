public class MainActivity extends AppCompatActivity {
    String imgPath;
    Bitmap imgBitmap;
    Uri imgUri;
    InputStream trainDataInputStream;
    OutputStream trainDataOutputStream;
    AssetManager assetManager;
    String externalDataPath;
    TextView t;
    String[] fileToBeCopied = {"eng.cube.bigrams", "eng.cube.fold", "eng.cube.lm", "eng.cube.nn", "eng.cube.params", "eng.cube.size", "eng.cube.word-freq", "eng.tesseract_cube.nn", "eng.traineddata","equ.traineddata"};
    ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.text);
        new CopyFile().execute();
        //placeFileFromAssetsToExternalStorage();
        takePicture();

    }

    class CopyFile extends AsyncTask {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Fetching image...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[0]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[1]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[2]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[3]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[4]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[5]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[6]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[7]);
            placeFileFromAssetsToExternalStorage(fileToBeCopied[8]);
            //placeFileFromAssetsToExternalStorage(fileToBeCopied[9]);

            return null;
        }


        @Override
        protected void onPostExecute(Object o) {
            pDialog.dismiss();

        }
    }

    private void takePicture() {
        File photoFile = null;
        Intent iPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (iPicture.resolveActivity(getPackageManager()) != null) {

            try {
                photoFile = createImageFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //if photo file is created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), "com.scorpio.fileprovider", photoFile);
                System.out.println(imgPath);
                iPicture.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(iPicture, 1);

            }
        }
    }

    private File createImageFile() {
        File imgFile = null;
        String fileStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = Environment.getExternalStorageDirectory();
        try {
            imgFile = File.createTempFile(fileStamp, ".jpeg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgPath = imgFile.getAbsolutePath();
        return imgFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            galleryAddPic();
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(imgPath);
        System.out.println("Image path ->" + imgPath);
        Uri contentUri = Uri.fromFile(f);
        imgUri = contentUri;
        System.out.println("Image uri " + imgUri);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
        ocrImage();
    }


    public void ocrImage() {
        try {
            //getting image for ocr
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            imgBitmap = BitmapFactory.decodeFile(imgPath, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int exifOrientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL);

        int rotate = 0;

        switch (exifOrientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                rotate = 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                rotate = 180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                rotate = 270;
                break;
        }

        if (rotate != 0) {
            int w = imgBitmap.getWidth();
            int h = imgBitmap.getHeight();

            // Setting pre rotate
            Matrix mtx = new Matrix();
            mtx.preRotate(rotate);

            // Rotating Bitmap & convert to ARGB_8888, required by tess
            imgBitmap = Bitmap.createBitmap(imgBitmap, 0, 0, w, h, mtx, false);
        }
        imgBitmap = imgBitmap.copy(Bitmap.Config.ARGB_8888, true);
        TessBaseAPI baseApi = new TessBaseAPI();
        baseApi.init(externalDataPath, "eng");
        baseApi.setImage(imgBitmap);
        String ocrResult = baseApi.getUTF8Text();
        System.out.println(ocrResult);
        baseApi.end();
        t.setText(ocrResult);

    }

    public void placeFileFromAssetsToExternalStorage(String filename) {
        System.out.println("Running DataRunnable class ");
        assetManager = getResources().getAssets();
        externalDataPath = Environment.getExternalStorageDirectory() + "/tessdata";
        System.out.println("external data path " + externalDataPath);
        //creating eng.trainedData
        File f = new File(externalDataPath);
        try {
            if (!f.exists()) {
                f.mkdir();
            }
            externalDataPath = externalDataPath + "/" + filename;
            f = new File(externalDataPath);

            if (!f.exists())
                f.createNewFile();

            externalDataPath = Environment.getExternalStorageDirectory().toString();

            trainDataInputStream = assetManager.open(filename);
            trainDataOutputStream = new FileOutputStream(f);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = trainDataInputStream.read(buffer)) != -1) {
                trainDataOutputStream.write(buffer, 0, read);
            }
            trainDataOutputStream.flush();
            trainDataOutputStream.close();
            trainDataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}