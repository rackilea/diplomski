public abstract class MyGenericType<T extends EntityClass> {

    protected abstract Class<T> getGenericType();

    @Override
    public String toString() {
        return this.getGenericType().getSimpleName();
    }
}

public class MyStudentType 
    extends MyGenericType<Student> {

    @Override
    protected Class<Student> getGenericType() {
        return Student.class;
    }
}