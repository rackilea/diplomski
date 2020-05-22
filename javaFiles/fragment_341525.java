public class ClientReaderThread extends Thread {

Socket socket;

ClientReaderThread(Socket socket) {
    this.socket = socket;
}

public void run() {
    try (BufferedReader serverReader = new BufferedReader(
            new InputStreamReader(socket.getInputStream()))){

        String fromServer = serverReader.readLine();;
        while(fromServer != null) {
             if (fromServer.equals("stop")) 
                break;
            System.out.println(fromServer);
            fromServer = serverReader.readLine();
        }
    } catch (IOException e) {
        System.out.println("Client error! Got exception: " + e);
    }
}

}