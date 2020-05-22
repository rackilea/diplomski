public class Foo {
    private static boolean flag = true;

    @Transactional
    public void doSomething() {
        flag = false;
    }
}