public Long insert(Note note) {
        try {
            Long id = new InsertNoteAsyncTask(mNoteDao).execute(note).get();
            Log.d(TAG, "insert: CALLED - REPOSITORY - LONG: " + id);
            return id;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }