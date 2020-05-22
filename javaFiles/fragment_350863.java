@Override
    public void onNoteClick(int position) {
        Log.d(TAG, "clicked on the position:" + position);
        if (position == 0) {
            Intent intent = new Intent(NoteActivity.this, RajeshDai.class);
            startActivity(intent);
        }