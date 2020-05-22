void takePhoto(View view) {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    File photo = new File(Environment.getExternalStorageDirectory(),  "image.jpg");
    intent.putExtra(MediaStore.EXTRA_OUTPUT,
            Uri.fromFile(photo));
    imageUri = Uri.fromFile(photo);
    startActivityForResult(intent, TAKE_PICTURE);
}