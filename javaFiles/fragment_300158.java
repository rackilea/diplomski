doInTransaction(session -> {
    int batchSize = batchSize();
    for(int i = 0; i < itemsCount(); i++) {

        //batch insert logic

        if(i % batchSize == 0 && i > 0) {
            session.flush();
            session.clear();
        }
    }
});