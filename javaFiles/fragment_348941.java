abstract class TestRootAbstractClass<T extends TestRootClass> implements TestInterface<T> {}

abstract class TestChildAbstractClass<T extends TestRootClass> extends TestRootAbstractClass<T> {}

interface TestInterface<T extends TestRootClass> {
    void test(T extendedTestClass) throws Exception;
}

abstract class TestRootClass {}

class TestChildClass extends TestRootClass {}

class TestImplementation extends TestChildAbstractClass<TestChildClass> {

    public void test(TestChildClass top) {
        System.out.println("tested");
    }
}