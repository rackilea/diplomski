public class SomethingTest {
    public static void main(String[] args) {
        new SomethingCaller();
    }
}

public class SomethingCaller {
    public void doSomething() {
        Class<?> somethingClass = Something.class;
    }
}

public class Something {}