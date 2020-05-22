private Note getItem(int position){
    if (!listNotes.moveToPosition(position)){
        throw new IllegalStateException("Position invalid");
    }
    return new Note(listNotes);
}