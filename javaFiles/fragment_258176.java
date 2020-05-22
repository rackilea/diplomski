public static class MyTaskParams{
        public String guid;
        public EvernoteNoteStoreClient noteStore;


    public MyTaskParams(String noteGuid, EvernoteNoteStoreClient noteStoreClient) {
        this.guid=noteGuid;
        this.noteStore=noteStoreClient;
    }