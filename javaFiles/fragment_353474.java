public class ObservableSocket extends Thread {
    private final Socket socket;
    private final ArrayList<ObservableSocketListener> listeners;
    private volatile boolean isReading;
    private int BUFFER_SIZE = 1024;

    public ObservableSocket(String host, int port) throws UnknownHostException, IOException {
        this.socket = new Socket(host, port);
        this.listeners = new ArrayList<ObservableSocketListener>(1);
        isReading = true;
        this.start();
    }

    public void addListener(ObservableSocketListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public void removeListener(ObservableSocketListener l) {
        if (!listeners.contains(l)) {
            listeners.remove(l);
        }
    }

    public void die() {
        isReading = false;
        try {
            this.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void write(byte[] data) throws IOException {
        socket.getOutputStream().write(data);
        socket.getOutputStream().flush();
    }

    private byte[] getData(byte[] buffer, int red) {
        byte[] redData = new byte[red];
        System.arraycopy(buffer, 0, redData, 0, red);
        return redData;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[BUFFER_SIZE];
        int red;
        ObservableSocketEvent event;
        try {
            while (isReading && (red = socket.getInputStream().read(buffer)) > -1) {
                event = new ObservableSocketEvent(this, getData(buffer, red));
                for (ObservableSocketListener l : listeners) {
                    l.dataAvailable(event);
                }
            }
        } 
        catch (Exception exception) {
            event = new ObservableSocketEvent(this, exception);
            for (ObservableSocketListener l : listeners) {
                l.errorOccured(event);
            }
        } 
        finally {
            if (socket != null) {
                try {
                    socket.close();
                    for (ObservableSocketListener l : listeners) {
                        l.closed(new ObservableSocketEvent(this));
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }   
}