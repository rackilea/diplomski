public String getRealPathFromURI(Uri contentUri) {
    String res = null;
    String[] proj = { MediaStore.Images.Media.DATA };
    Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
    if(cursor.moveToFirst()){;
       int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
       res = cursor.getString(column_index);
    }
    cursor.close();
    return res;
}