public class SensorConnector {


    private SensorListener listener;

    public void setSensorListener(SensorListener listener){
        this.listener = listener;
    }

    public void removeListener(){
        this.listener = null;
    }

    public void startThread(){

        new Thread(new Runnable() {
            @Override public void run() {

                    byte[] buffer = new byte[1024];
                    int bytes;
                    // Keep listening to the InputStream while connected
                    while (true) {
                        try {
                            // Read from the InputStream
                            bytes = mmInStream.read(buffer);
                            String incomingMessage = new String(buffer, 0, bytes);

                            // Code to send incomingMessage to Dataview
                            if(listener != null) {
                                listener.onUpdate(incomingMessage);
                            }

                        } catch (IOException e) {
                            Log.d(TAG, "disconnected " + e);
                            break;
                        } finally {
                            removeListener();
                        }
                    }
            }
        }).start();
    }
}