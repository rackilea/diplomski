// static variable, single reference is shared across all instances of the class
private static Socket ssocket = null;

public ClientGUI() throws IOException {
    // ssocket is not initialized here
}

public int sendToServer(String text) {
    try (

        if (ssocket == null) {
            // typo, socket is used in code instead of ssocket 
            ssocket = new Socket("127.0.0.1", 123456);
        }
        // ...
    } catch (Exception e) {
        // if connectivity issue occurred, you can close the ssocket and set to null here
        // ...
    }
}