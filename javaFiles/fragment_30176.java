public class MyPingTask implements Callable<Boolean> {
    private String address;
    public MyPingTask(String address) {
        this.address = address;
    }
    public Boolean call() throws Exception {
         // obviously the pingUrl code could go right here
         return pingUrl(address);
    }
}