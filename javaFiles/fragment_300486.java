String mCurrentPhotoPath;  

  private void takePicture() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
        // Create the File where the photo should go
        File photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            // Error occurred while creating the File
            Log.d("Error", "" + ex.getMessage());
        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            Uri photoURI = null;
            if ((Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)) {
                photoURI = FileProvider.getUriForFile(getActivity(),
                        "com.your_packageName.provider",
                        photoFile);
            } else {
                photoURI = Uri.fromFile(photoFile);
            }
            if (photoURI != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
}



    private File createImageFile() throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir =    getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */
    );

    // Save a file: path for use with ACTION_VIEW intents
    mCurrentPhotoPath = image.getAbsolutePath();
    Log.d("path", mCurrentPhotoPath);
    return image;
}



 @Override
 public void onActivityResult(int requestCode, int resultCode, Intent data) {

    switch (requestCode) {
        case REQUEST_TAKE_PHOTO: {
            if (resultCode == RESULT_OK) {
                File file = new File(mCurrentPhotoPath);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media
                            .getBitmap(getActivity().getContentResolver(), Uri.fromFile(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bitmap != null) {
                    // Glide.with(this).load(Uri.fromFile(file)).into(imageView);
                    Uri fileUri = Uri.fromFile(file);
                    Log.d("URI", fileUri.toString());
                    // Get length of file in bytes
                    long fileSizeInBytes = file.length();
                    // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
                    long fileSizeInKB = fileSizeInBytes / 1024;
                    // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
                    long fileSizeInMB = fileSizeInKB / 1024;

                } else {
                    Log.d("file", "URI is null");
                }
            }
        }
        break;
 }
}