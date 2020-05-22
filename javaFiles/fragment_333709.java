enum Test implements Bar {
    ONE, TWO
}

class Foo<T> extends FooAbstract<Test> {
    public Foo() {
        ParameterizedType genericSuperclass =
                (ParameterizedType) getClass().getGenericSuperclass();
        baz((Class<T>) genericSuperclass.getActualTypeArguments()[0]);
    }

    private void baz(Class<T> qux) {
        T[] constants = qux.getEnumConstants();
        System.out.println(Arrays.toString(constants)); // print [ONE, TWO]
    }
}

interface Bar {
}

class FooAbstract<T extends Enum<?> & Bar> {
}