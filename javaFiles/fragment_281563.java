import java.lang.reflect.ParameterizedType;


public class ChildClass extends GenericClass<Foo> {

    public ChildClass() {
        System.out.println(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]); //output: class Foo
    }

}