private Uri getUri() {
    String state = Environment.getExternalStorageState();
    if(!state.equalsIgnoreCase(Environment.MEDIA_MOUNTED)) {
        return MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    }

    return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
}