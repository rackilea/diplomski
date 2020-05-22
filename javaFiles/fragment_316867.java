public class Foo {
    private boolean flag = true;

    @Transactional
    public void doSomething() {
        flag = false;
    }
}