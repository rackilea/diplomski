public class DatabaseModel<T, ID> {
    private Dao<T, ID> mDao = null;
    private DatabaseHelper mHelper;
    private Class<T> mClass;

    public DatabaseModel(DatabaseHelper h, Class<T> c) {
        mHelper = h;
        mClass = c;
        try {
            mDao = mHelper.getDao(mClass);
        } catch (SQLException e) {
            Debug.e("Can't get dao", e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}