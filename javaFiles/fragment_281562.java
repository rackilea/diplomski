import java.lang.reflect.ParameterizedType;


public class GenericClass<T> {

    public GenericClass() {
        System.out.println(getClass().getGenericSuperclass()); //output: GenericClass<Foo>
        System.out.println(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]); //output: class Foo
    }

    public static void main(String[] args) {
        new ChildClass();
    }

}