private void takePicture() {
    File newdir = new File(getImageDir());
    newdir.mkdirs();

    String file = getFileName();
    File newfile = new File(file);
    try {
        newfile.createNewFile();
    } catch (IOException e) {}

    Uri outputFileUri = Uri.fromFile(newfile);

    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

    startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUST_CODE);
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUST_CODE && resultCode == RESULT_OK) {
        useFileName(getFileName());
    }
}