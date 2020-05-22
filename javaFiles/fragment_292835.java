public void add(Note note) {
    PersistenceManager pm = getPersistenceManagerFactory()
            .getPersistenceManager();
    try {
        pm.makePersistent(note);
    } finally {
        pm.close();
    }
}