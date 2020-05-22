public static void main(String[] args) {
    // This queue will be the link between the threads where 
    // they can pass messages to each other
    BlockingQueue<String> messages = new LinkedBlockingQueue<>();

    PrintWriter printer = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    TransmitterTwo trans = new TransmitterTwo(socket, queue);
    trans.start(); // Gets the message from socket

    ...

    while(true) {
          String readerInput = reader.readLine(); // Read from console
          printer.println(readerInput.trim()); // Sends it to the socket

          // Wait for the other thread to push a message in to the queue.
          String recv = messages.take();
    }
}

public class TransmitterTwo extends Thread {
    final Socket socket;
    final BlockingQueue<String> queue;

    TransmitterTwo(Socket socket, BlockingQueue<String> queue) {
        this.socket = socket;
        this.queue = queue;
    }

    public void run() {
        try {
            String response = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((response = reader.readLine()) != null) {
                System.out.println("Server response: " + response);
                // Add the response from the server to the queue
                queue.add(response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}