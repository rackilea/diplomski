// Execute the code below inside a transaction
Session session = ...;
FullTextSession fullTextSession = Search.getFullTextSession( session );
int index = 0;
while(results.next()) {
    index++;

    // TODO: add code here to insert one row

    if (index % BATCH_SIZE == 0) {
        session.flush(); //apply changes to the database
        fullTextSession.flushToIndexes(); //apply changes to indexes
        fullTextSession.clear(); //free memory since the queue is processed
    }
}