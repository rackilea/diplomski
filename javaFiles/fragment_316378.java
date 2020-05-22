Session session = NotesFactory.createSession(host, user, password);
View view = session.getDatabase(DATABASE).getView(VIEW);
ViewEntryCollection allEntries = view.getAllEntries();
ViewEntry entry = allEntries.getFirstEntry();
while (entry != null) {
    if (entry.isDocument()) {
        Document doc = entry.getDocument();
        String no = doc.getItemValueString("No");
    }
    entry = allEntries.getNextEntry();
}