public class Bar {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //find class
        Class<?> fooClass = Class.forName("foo.Foo");

        //find constructor for given arguments
        Constructor<?> fooConstructor = fooClass.getConstructor(String.class, int.class);

        //call constructor
        Object foo = fooConstructor.newInstance("FooBar", 100);

        //find method
        Method getFooMethod = fooClass.getDeclaredMethod("getFoo");
        Method setFooMethod = fooClass.getDeclaredMethod("setFoo", String.class);
        Method getBarMethod = fooClass.getDeclaredMethod("getBar");
        Method setBarMethod = fooClass.getDeclaredMethod("setBar", int.class);

        //call method
        Object fooResult = getFooMethod.invoke(foo);
        System.out.println(fooResult);

        Object barResult = getBarMethod.invoke(foo);
        System.out.println(barResult);

        setFooMethod.invoke(foo, "BarFoo");
        setBarMethod.invoke(foo, 200);

        fooResult = getFooMethod.invoke(foo);
        System.out.println(fooResult);

        barResult = getBarMethod.invoke(foo);
        System.out.println(barResult);
    }
}

public class Foo {
    private String foo;
    private int bar;

    public Foo(String foo, int bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }
}