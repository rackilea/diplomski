public class Driver {
    public static void main(String[] args) throws Exception {
        garbage();

        System.gc();
        Thread.sleep(1000);
    }

    public static void garbage() {
        Driver collectMe = new Driver();
    }

    @Override
    protected void finalize() {
        System.out.println(Thread.currentThread().getName() + ": See ya, nerds!");
    }
}