public class Asynctask extends AsyncTask<String, Void, Void> {
    private static final String IP_ADDRESS = "134.190.162.165";  // Toshiba laptop
    //  private static final String IP_ADDRESS = "10.0.0.2";  // Toshiba laptop
    private static final int DEST_PORT = 4444;

    private EditText mTextField;

    /**
     * Store provided views (used later in onPostExecute(...)).
     * 
     * Create socket to communicate with server (blocking call).
     */
    protected Void doInBackground(String... messages) {
        if (messages.length != 1) { return null; }
        String message = messages[0];

        // Create socket.
        Socket client = null;

        try {
            client = new Socket(IP_ADDRESS, DEST_PORT); // connect to server
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write to server.
        try {
            printwriter = new PrintWriter(client.getOutputStream(), true);
            printwriter.write(messsage); // write the message to output stream

            printwriter.flush();
            printwriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}