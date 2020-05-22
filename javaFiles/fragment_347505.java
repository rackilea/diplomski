public HashMap<String, List<String>> userNotesStore = new HashMap<String, List<String>>();

/**
 * Adds a note to the users list of notes.
 * @param username
 * @param note
 */
private void addNote(String username, String note) {
    List<String> notes = userNotesStore.get(username);
    if(notes == null) {
        notes = new ArrayList<String>();
        userNotesStore.put(username, notes);
    }
    notes.add(note);
}