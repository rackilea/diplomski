private void getPhoneGalleryImages() {

    Cursor cursor = cr.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null,
            null, null);
    cr = getActivity().getContentResolver();
    if(cursor != null)
    {
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Thumbnails._ID));
                String path = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}