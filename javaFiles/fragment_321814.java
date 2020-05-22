protected static boolean exists(String table, long id) throws Exception
{
    Db db = Util.getDb();
    Query q = db.query();
    q.select( idField ).whereLong(idField, id).limit(1).get(table);

    return q.hasResults();
}