public static String getCreateQuery() {
    return "CREATE TABLE application (\n" +
            "    \"_id\" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    \"package\" TEXT,\n" +
            "    \"orientation\" TEXT,\n" +
            "    \"category_id\" INTEGER NOT NULL DEFAULT (1),\n" +
            "    \"icon\" INTEGER,\n" +
            "    \"name\" TEXT\n" +
            ")\n" +
            "";
}