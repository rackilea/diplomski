public static String getRealPathFromURI(Context context, Uri uri) {
        if( "content".equalsIgnoreCase( uri.getScheme() ) ) {
            String[] projection = { MediaStore.Images.Media.DATA };
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
                e.printStackTrace();
            } finally {
                if(cursor != null) {
                    cursor.close();
                }
            }
        } else if( "file".equalsIgnoreCase( uri.getScheme() ) ) {
            return uri.getPath();
        }
        return null;
    }