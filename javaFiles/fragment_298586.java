public interface EntityClass {
    public void setId(final Integer id);

    public Integer getId();
}

public class Student
    implements EntityClass {

    // getters and setters
}

public abstract class MyGenericType<T extends EntityClass> {

    private final Class<T> genericClazz;

    @SuppressWarnings("unchecked")
    public MyGenericType() {
        this.genericClazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
    }

    protected Class<T> getGenericClazz() {
        return this.genericClazz;
    }

}

public class MyStudentType // no way to avoid extending a generic type
    extends MyGenericType<Student> {

    @Override
    public String toString() {
        return this.getGenericClazz().getSimpleName();
    }
}

public class Sample {

    public static void main(String[] args) {
        final MyStudentType action = new MyStudentType();
        System.out.println(action); // Student
    }
}