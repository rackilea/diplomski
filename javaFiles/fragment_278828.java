public class DataReceiver implements Runnable {

    private Socket clientSocket;
    private BufferedReader socketIn;
    private Supplier<Runnable> runnableSupplier;

    public DataReceiver(Socket clientSocket, Supplier<Runnable> runnableSupplier) { /* ... */ }

    @Override
    public void run() {
        // ...
        while ((inputLine = socketIn.readLine()) != null) {
            // ...
            new Thread(runnableSupplier.get()).start();
            // ...
        }
        // ...
    }
}