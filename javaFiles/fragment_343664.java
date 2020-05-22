private final Queue<DB> freeDBs = new ConcurrentLinkedQueue<>();

public DB acquireDB() {
    DB db = freeDBs.poll();
    if (db != null && db.isConnectionValid()) 
        return db;
    if (db != null)
        db.close();
    return getDBConnection();
}

public void release(DB db) {
    if (freeDBs.size() >= MAX_FREE_SIZE)
        db.close();
    else
        freeDBs.add(db);
}