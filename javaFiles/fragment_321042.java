public String getNameFromURI(Uri contenturi){

    String[] proj = {
            OpenableColumns.DISPLAY_NAME,
            OpenableColumns.SIZE
    };
    String name = null;
    int size= 0;
    Cursor metadataCursor = getContentResolver().query(contenturi,  proj, null, null, null);

    if (metadataCursor != null) {
        try {
            if (metadataCursor.moveToFirst()) {
                name = metadataCursor.getString(0);
                size = metadataCursor.getInt(1);
            }
        } finally {
            metadataCursor.close();
        }
    }

    return name;
}