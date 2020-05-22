public class DataListener implements Runnable {

    private final Socket receive;

    public DataListener(final Socket receive){
        this.receive = receive;
    }

    @Override
    public void run() {
        // do stuff with your connected socket
        // do proper resource/exception handling
        // close the socket here
    }
}