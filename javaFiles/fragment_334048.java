public void getAllSongs() {

    Uri allsongsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

    cursor = managedQuery(allsongsuri, STAR, selection, null, null);

    if (cursor != null) {
        if (cursor.moveToFirst()) {
            do {
                song_name = cursor
                        .getString(cursor
                                .getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                int song_id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.Audio.Media._ID));

                String fullpath = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Audio.Media.DATA));
                fullsongpath.add(fullpath);

                album_name = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Audio.Media.ALBUM));
                int album_id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));

                artist_name = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Audio.Media.ARTIST));
                int artist_id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.Audio.Media.ARTIST_ID));


            } while (cursor.moveToNext());

        }
        cursor.close();
        db.closeDatabase();
    }
}