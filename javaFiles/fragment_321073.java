public class SuperClass {
    public void test() {
        System.out.println("Test");
    }

    public static class SubClass extends SuperClass {
        public void testSub() {
            System.out.println("Test sub");
        }

        @Override
        public void test() {
            System.out.println("Override test");
        }
    }

    public static void main(String[] args) {
        SuperClass sc = new SuperClass();
        sc.test();                      // prints Test
        sc = new SubClass();
        sc.test();                      // prints Override test
        sc.testSub();                   // does not compile
        ((SubClass) sc).testSub();      // prints Test sub
    }
}