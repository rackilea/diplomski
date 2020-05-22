final Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        final String[] cursor_cols = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE,
        };
        final String where = MediaStore.Audio.Media.IS_MUSIC + "=1";
        final Cursor cursor = getContentResolver().query(uri, cursor_cols, where, null, null);
        cursor.moveToNext();
        final String artist = cursor.getString(_cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
        final String album = cursor.getString(_cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
        final String track = cursor.getString(_cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
        doSomethingInteresting(artist, album, track);