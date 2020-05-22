public class MyFieldClassPersister extends StringType {

    private static final MyFieldClassPersister INSTANCE = new MyFieldClassPersister();

    private MyFieldClassPersister() {
        super(SqlType.STRING, new Class<?>[] { MyFieldClass.class });
    }

    public static MyFieldClassPersister getSingleton() {
        return INSTANCE;
    }

    @Override
    public Object javaToSqlArg(FieldType fieldType, Object javaObject) {
        MyFieldClass myFieldClass = (MyFieldClass) javaObject;
        return myFieldClass != null ? getJsonFromMyFieldClass(myFieldClass) : null;
    }

    @Override
    public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) {
        return sqlArg != null ? getMyFieldClassFromJson((String) sqlArg) : null;
    }

    private String getJsonFromMyFieldClass(MyFieldClass myFieldClass) {
        // logic here
    }

    private MyFieldClass getMyFieldClassFromJson(String json) {
        // logic here
    }
}