Cursor cursor = getContentResolver().query(
              ContentUris.withAppendedId(
                  MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, albumId),
              new String[] { MediaStore.Audio.AlbumColumns.ALBUM_ART },
              null,
              null,
              null);

if (cursor.moveToFirst()) {
    String albumArtUri = cursor.getString(0);
}

cursor.close();