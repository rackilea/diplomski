public void onClick(View v) {
    switch (v.getId()) {
    case R.id.ibTakePic:
        i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, getOutputMediaFileUri());
        startActivityForResult(i, cameraData);
        break;
    }
}

private Uri getOutputMediaFileUri() {
    File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
    imagesFolder.mkdirs();   
    File image = new File(imagesFolder, "image.jpg");
    return Uri.fromFile(image);
}