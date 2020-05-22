private class CardClickListener implements View.OnClickListener {
    private int id;
    CardClickListener(int id) {
        this.id = id;
    }
    public void onClick(View v) {
        Log.d("XYZ", "My id is: " + id);

        Intent i = new Intent(NotesListActivity.this, NoteEdit.class);
        // i.putExtra(NotesDbAdapter.KEY_ROWID, (Integer)cardsLayout.getTag());
        i.putExtra(NotesDbAdapter.KEY_ROWID, id);
        startActivityForResult(i, ACTIVITY_EDIT);
    }
}