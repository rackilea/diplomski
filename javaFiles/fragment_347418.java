public class LambdaTest {

    public void test() {
        Runnable runnable = this::run;
        runnable.run();
    }

    public void run() {
    }

}