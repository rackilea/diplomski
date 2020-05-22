public class MyDatePersister extends com.j256.ormlite.field.types.BaseDataType {
    private static final MyDatePersister singleTon = new MyDatePersister();
    @SuppressWarnings("deprecation")
    private static final Timestamp ZERO_TIMESTAMP = new Timestamp(0, 0, 0, 0, 0, 0, 0);

    private MyDatePersister() {
        super(SqlType.DATE, new Class<?>[] { Date.class });
    }

    public static MyDatePersister getSingleton() {
        return singleTon;
    }

    @Override
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults results,
            int columnPos) throws SQLException {
        Timestamp timestamp = results.getTimestamp(columnPos);
        if (timestamp == null || ZERO_TIMESTAMP.equals(timestamp)) {
            return null;
        } else {
            return timestamp;
        }
    }
}