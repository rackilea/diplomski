List<Long> mediaStoreIds = new ArrayList<Long>();

    Cursor c = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{BaseColumns._ID}, null, null, null);

    if (c != null) {
        final int id = c.getColumnIndexOrThrow(BaseColumns._ID);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            Long mediaStoreId = c.getLong(id);

            mediaStoreIds.add(mediaStoreId);
            c.moveToNext();
        }
        c.close();
    }