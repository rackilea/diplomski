public abstract class BaseDAO<T extends BaseDTO> {

    public boolean update(T t) throws DBException {
        Integer id = t.getID();
        Field[] fields = t.getClass().getDeclaredFields();
        // Assuming you have a db object to execute queries using bind variables:
        boolean success = db.execute("UPDATE table SET ... WHERE id = ?", id.intValue());
        return success;
    }
}