@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_RESULT) {
                Uri imageUri = data.getData();
                startActivity(MainActivity.getIntent(this, uriToBundle(Objects.requireNonNull(imageUri))));
            } else if (requestCode == CAMERA_RESULT) {

                //Reducing Image Size
                File imageFile = new File(mCapturedImagePath);
                Bitmap image = BitmapFactory.decodeFile(mCapturedImagePath);
                image = Bitmap.createScaledBitmap(image, 300, 300, false);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

                //This section is needed as you need to replace the image got from camera with reduced bitmap.
                //So that you just only need to carry URI not the bitmap.
                try {
                    File file = new File(Environment.getExternalStorageDirectory() + File.separator + "filename.jpg");
                    boolean result;
                    result = file.createNewFile();
                    if (result) {
                        FileOutputStream fo = new FileOutputStream(imageFile);
                        fo.write(bytes.toByteArray());
                        fo.close();
                    }
                } catch(IOException ie) {
                    ie.printStackTrace();
                }

                // Here's the main point.
                // You need to start MainActivity as bitmap has been processed.
                startActivity(MainActivity.getIntent(this, uriToBundle(Objects.requireNonNull(imageToUploadUri))));

            }
        } else {
            Toast.makeText(this, "Image not loaded.", Toast.LENGTH_SHORT).show();
        }
    }