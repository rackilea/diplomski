// src/author/MyClass.java

public class MyClass {
    public MyClass() {
        setup();
    }

    protected void setup() {
        throw new Exception("I hate unit testing !");
    }

    public boolean doesItWork() {
        return true;
    }
}

// test/author/MyClass.java

public class MyClassTest {
    private class MockedMyClass extends MyClass {
        @Override
        protected void setup() {

        }
    }

    private MyClass instance;

    @Before
    public void setUp() { // Not to be confusing with `MyClass#setup()`!
        instance = new MockedMyClass();
    }

    @Test
    public void test_doesItWork() {
        assertTrue(instance.doesItWork());
    }

}