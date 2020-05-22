private void startCropActivity(Uri filePath){
    try {
        Intent cropIntent = new Intent("com.android.camera.action.CROP");
        cropIntent.setDataAndType(filePath, "image/*");
        cropIntent.putExtra("crop", true);
        cropIntent.putExtra("aspectX", 1);
        cropIntent.putExtra("aspectY", 1);
        cropIntent.putExtra("outputX", 128);
        cropIntent.putExtra("outputY", 128);
        cropIntent.putExtra("return-data", true);

        startActivityForResult(cropIntent, PIC_CROP);

    }catch (ActivityNotFoundException anfe) {
        // display an error message
        Toast.makeText(this, "Could not crop", Toast.LENGTH_SHORT).show();

    }
}