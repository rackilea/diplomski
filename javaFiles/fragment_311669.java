doInTransaction(session -> {
    for (int i = 0; i < 5; i++) {
        session.persist(new AssignTableSequenceIdentifier());
    }
    AssignTableSequenceIdentifier tableSequenceIdentifier = new AssignTableSequenceIdentifier();
    tableSequenceIdentifier.id = -1L;
    session.merge(tableSequenceIdentifier);
    session.flush();
});