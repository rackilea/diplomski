public class T_Test {
    @Tested T tested;

    @Capturing D dependency;

    public void test() {
        dependency.doSomething();
        tested.testedMethod(dependency);
    }
}