abstract class TestRootAbstractClass implements TestInterface {}
abstract class TestChildAbstractClass extends TestRootAbstractClass{}
interface TestInterface<T extends TestRootClass> {
    void test(T extendedTestClass) throws Exception;
}
abstract class TestRootClass {}
class TestChildClass extends TestRootClass {}
class TestImplementation extends TestChildAbstractClass {

    public void test(TestRootClass top) {
        System.out.println("tested");
    }
}