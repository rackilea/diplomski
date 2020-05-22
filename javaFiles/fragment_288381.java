if (uri != null) {
    try {
        if( uri == null ) {
            IMAGE_FILEPATH = uri.getPath();
        } else {
            // get the id of the image selected by the user
            String wholeID = DocumentsContract.getDocumentId(data.getData());
            String id = wholeID.split(":")[1];

            String[] projection = { MediaStore.Images.Media.DATA };
            String whereClause = MediaStore.Images.Media._ID + "=?";
            Cursor cursor = getContentResolver().query(getUri(), projection, whereClause, new String[]{id}, null);
            if( cursor != null ){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                if (cursor.moveToFirst()) {
                    IMAGE_FILEPATH = cursor.getString(column_index);
                }

                cursor.close();
            } else {
                IMAGE_FILEPATH = uri.getPath();
            }
        }
    } catch (Exception e) {
        Crouton.makeText(this, "Failed to get image", Style.ALERT).show();
    }
}