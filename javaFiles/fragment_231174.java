public class OuterFoo {
    private class InnerFoo1 {
        private void helloFoo1 () {
            System.out.println("foo1");

            InnerFoo2 foo2 = new InnerFoo2();
            foo2.helloFoo2();
        }
    }
    private class InnerFoo2 {
        private void helloFoo2 () {
            System.out.println("foo2");

            InnerFoo1 foo1 = new InnerFoo1();
            foo1.helloFoo1();
        }
    }
}