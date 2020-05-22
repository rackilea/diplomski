public class Blaaa {
    ...
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    public synchronized void sendData(String data) {
        outToServer.writeBytes(data + "\n");
    }
 }