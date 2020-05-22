public boolean update(Object o) throws DBException {
    // This line doesn't work, since Object doesn't have a getID() method.
    Integer id = t.getID();
    Field[] fields = o.getClass().getDeclaredFields();

    boolean success = db.execute("UPDATE table SET ... WHERE id = ?", id.intValue());
    return success;
}