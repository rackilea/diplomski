getSaveButton().setOnClickListener(new AdapterView.OnClickListener() {
    public void onClick(View view) {
        Cursor myCursor = createPlaylistCursor(sort);
        int i = 0;
        if(myCursor.moveToFirst()) {
            Uri playListUri = getPlaylistUri();
            ContentValues[] values = new ContentValues[myCursor.getCount()];
            ContentResolver contentResolver = getContentResolver();
            do {
                ContentValues map = new ContentValues();
                map.put(PLAY_ORDER_KEY, Long.valueOf(i + 1));
                map.put(AUDIO_ID_KEY, myCursor.getInt(myCursor.getColumnIndexOrThrow(AUDIO_ID_KEY)));
                values[i++] = map;
            } while(myCursor.moveToNext());
            contentResolver.delete(playListUri, null, null);
            contentResolver.bulkInsert(playListUri, values);
            Log.d("BLA", "done");
        }
    }
});