public class Service1 implements Callable<Object> {

    public Service1() {
        try {
            java.util.concurrent.TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}