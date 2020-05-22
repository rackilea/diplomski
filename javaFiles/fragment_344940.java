String DISPLAY_NAME = MediaStore.Audio.Media.DISPLAY_NAME;
    String projection[] = {MediaStore.Audio.Media.ALBUM_ID};
    String selection = DISPLAY_NAME + " = ?";
    String[] selectionArgs = {"your file name.mp3"};
    String order = null;

    Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection, selection, selectionArgs, order);
    // **now use cursor** //