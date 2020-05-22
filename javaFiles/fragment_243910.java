public class Example {

    @AOPExample
    public void tryMe() {
        System.out.println("example working...");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}