public static DB getDb() {
    if (db == null) {
        init();
    }
    return db;
}