public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {
            MediaStore.Audio.Media.DATA
        };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }