public static String getPathFromURI(Uri contentUri) {

        Cursor cursor = null;
        try {
            final String[] proj = {MediaStore.Images.Media.DATA};
            cursor = getAppContext().getContentResolver().query(contentUri, proj, null, null, null);
            if (cursor == null || cursor.getCount() == 0)
                return "";
            final int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } catch (IllegalArgumentException|SecurityException e) {
                return "";
        } finally {
            if (cursor != null && !cursor.isClosed()) cursor.close();
        }
    }