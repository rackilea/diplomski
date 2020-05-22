import java.util.Date;

public class MyRunnableTask implements Runnable {

    private String hostName;
    private int port;

    MyRunnableTask(String _hostName, int _port){
        this.hostName = _hostName;
        this.port = _port;
    }

    @Override
    public void run() {
        System.out.println(this.hostName + ":: I am getting executed: " + this.hashCode() + " | " + Thread.currentThread().getId() + " | " + new Date());

        // implement your socket programming code here

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}