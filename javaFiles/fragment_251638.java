public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                Bitmap myBitmap = BitmapFactory.decodeFile(selectedImagePath);
                b1.setImageBitmap(myBitmap);
            }
        }
    }