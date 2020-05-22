public class GpsReader {
    public class GenericGPSException extends Exception {

        public GenericGPSException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {

        // Example of usage

        GpsReader gpsReader = new GpsReader();

        String messageFromDevice;
        try {
            // Try read it
            messageFromDevice = gpsReader.getCoordinate();
        } catch (GenericGPSException e) {
            // Error, what does it says?
            messageFromDevice = e.getMessage();
        }

        JTextArea mockArea = new JTextArea();
        // Show to user anything that comes to it.
        mockArea.setText(messageFromDevice);

    }

    private boolean isReady;

    private RandomAccessFile port;

    public GpsReader() {
    }

    public String getCoordinate() throws GenericGPSException {

        if (!isReady) {
            try {
                port = new RandomAccessFile("COM3", "rwd");
                port.writeBytes("\r\n");
                port.writeBytes("c,31,0,0,5\r\n");
                port.writeBytes("T,1000,1\r\n");
                isReady = true;
            } catch (FileNotFoundException e) {
                throw new GenericGPSException(
                        "Error at starting communication to Device ", e);
            } catch (IOException e) {
                throw new GenericGPSException(
                        "Error at starting communication to Device ", e);
            }

        }

        try {
            return port.readLine();
        } catch (IOException e) {
            throw new GenericGPSException("Error at reading the Device ", e);
        }
    }
}