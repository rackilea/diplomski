public String getPath(Uri uri) {
        if(uri.getScheme().equals("content")){
                String[] projection = { MediaStore.Images.Media.DATA };
                Cursor cursor = managedQuery(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(
                        MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
        } else if(uri.getScheme().equals("file")){
                File myFile = new File(uri);
                return myFile.getAbsolutePath();
        }
}