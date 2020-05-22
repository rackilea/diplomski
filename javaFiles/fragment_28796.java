private String getRealPathFromURI(Uri contentURI) {

    String result;
    String[] filePathColumn = { MediaStore.Images.Media.DATA };        

    Cursor cursor = getContentResolver().query(contentURI, filePathColumn, null, null, null);
    if (cursor == null) { // Source is Dropbox or other similar local file path
        result = contentURI.getPath();
    } else {
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(filePathColumn[0]);
        result = cursor.getString(idx);
        cursor.close();
    }
    return result;
}