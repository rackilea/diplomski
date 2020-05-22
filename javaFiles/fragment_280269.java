public class Foo<T> {

    private T value;

    public Foo(T value) {    
        this.value = value;
    }      
}

public class FooInt extends Foo<Integer>{
    public FooInt(Integer value) {
        super(value);
    }
}

public class FooDouble extends Foo<Double>{
    public FooDouble(Double value) {
        super(value);
    }
}