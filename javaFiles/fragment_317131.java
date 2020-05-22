@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {
            ...
            Bitmap bitmap=BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
            imageview.setImageBitmap(bitmap);
            ...
        }
    }