public class takefoto extends BaseNavegationActivity {

Button takebt, sendbt;
String ba1;
String mCurrentPhotoPath;
ImageView mFoto;
int CodServico;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.takefoto);

    takebt = (Button) findViewById(R.id.takebt);
    mFoto = (ImageView) findViewById(R.id.fotoser);
    takebt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            captureImage();
        }
    });

    sendbt = (Button) findViewById(R.id.sendbt);
    sendbt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            upload();
        }
    });

    Bundle extras = getIntent().getExtras();
    CodServico=extras.getInt("CodServico");
    Log.i("CODSERVICO",CodServico+"");

}

private void upload() {
    Bitmap bm = BitmapFactory.decodeFile(mCurrentPhotoPath);
    ByteArrayOutputStream bao = new ByteArrayOutputStream();
    bm.compress(Bitmap.CompressFormat.JPEG, 50, bao);
    byte[] ba = bao.toByteArray();
    Log.i("IMAGEM NAO CONVERTIDA",ba+"");
    ba1 = Base64.encodeToString(ba,Base64.DEFAULT);
    // Get image and
    // Upload image to server
    ServerRequests serverRequests = new ServerRequests(takefoto.this);
    serverRequests.storeFotoDataInBackground(ba1, CodServico, new GetUpdaterCallBack() {
        @Override
        public void done(String returnUser) {
            if (returnUser.equalsIgnoreCase("sucesso")) {
                Toast.makeText(getApplicationContext(),"Enviado!",Toast.LENGTH_SHORT).show();
            } else{
                showError();
            }
        }
    });

}

private void captureImage() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        // Create the File where the photo should go
        File photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            // Error occurred while creating the File
            ex.printStackTrace();
        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(photoFile));
            startActivityForResult(takePictureIntent, 100);
        }
    }
}

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 100 && resultCode == RESULT_OK) {
        setPic();
    }
}

private void setPic() {
    // Get the dimensions of the View
    int targetW = mFoto.getWidth();
    int targetH = mFoto.getHeight();

    // Get the dimensions of the bitmap
    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
    bmOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
    int photoW = bmOptions.outWidth;
    int photoH = bmOptions.outHeight;

    // Determine how much to scale down the image
    int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

    // Decode the image file into a Bitmap sized to fill the View
    bmOptions.inJustDecodeBounds = false;
    bmOptions.inSampleSize = scaleFactor;
    bmOptions.inPurgeable = true;

    Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
    mFoto.setImageBitmap(bitmap);
}

private File createImageFile() throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES);

    File image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */
    );

    // Save a file: path for use with ACTION_VIEW intents
    mCurrentPhotoPath = image.getAbsolutePath();
    Log.e("Getpath", "Cool" + mCurrentPhotoPath);
    return image;
}

private void showError(){
    android.app.AlertDialog.Builder dialogBuilder=new android.app.AlertDialog.Builder(getBaseContext());
    dialogBuilder.setMessage("Ocorreu um erro, por favor tente novamente mais tarde.");
    dialogBuilder.setPositiveButton("Ok", null);
    dialogBuilder.show();
}
}