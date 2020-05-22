class A<T> {

    T daField;

    public void setField(T pField) {
        daField = pField;
    }

    public T getField() {
        return daField;
    }
}

class B<T> extends A {//empty
}

class Test {

    public static void main(String... args) {
        B<Object> testB1 = new B<>(); //
        testB1.setField(new Object());
        System.out.println(testB1.getField());
        B<String> testB2 = new B<>();
        testB2.setField("blah blah");
        System.out.println(testB2.getField());
        B<Integer> testB3 = new B<>();
        testB3.setField(42);
        System.out.println(testB3.getField());
    }
}