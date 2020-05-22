public class Foo {

    public void test1() {
        long timeout = System.currentTimeMillis() + 500;
        int i = 0;
        while (System.currentTimeMillis() < timeout) {
            System.out.println(i++);
            try {Thread.sleep(50);} catch (Exception ex) {}
        }
    }


    public static void main(final String ... args) throws Exception {
        new Foo().test1();
    }

}