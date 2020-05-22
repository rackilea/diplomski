public static String getCreateQuery()
{
    return "CREATE TABLE application " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "package TEXT, " +
            "orientation TEXT, " +
            "category_id INTEGER NOT NULL DEFAULT (1), " +
            "icon INTEGER, " +
            "name TEXT)"
}