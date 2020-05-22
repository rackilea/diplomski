import java.io.*;
import java.net.*;

public class MyServer {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    String msg = "";
    ServerSocket sSocket = null;
    Socket clientSocket;
    int port = 2222;// Integer.parseInt(args[0]);
    try {
      sSocket = new ServerSocket(port);

    } catch (IOException e) {
      System.out.println(e);
    }

    while (true) {
      try {// listen for a connection from client and accept it.
        System.out.println("Server is listenning on host: " + InetAddress.getLocalHost().getHostAddress() + "" + " and on port: "
            + port);

        clientSocket = sSocket.accept();
        System.out.println("Connection accepted");
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // PrintWriter out =
        // new PrintWriter(clientSocket.getOutputStream(), true);

        PrintStream output = new PrintStream(clientSocket.getOutputStream());

        msg = input.readLine();
        if (msg != null) {
          if (msg.length() > 12 && msg.charAt(12) == '4') {

            System.out.println("reading message " + msg + " ");
            output.println("Bye");
            System.out.println("Server exits");
          } else {
            if (msg.length() > 12 && msg.charAt(12) == '0') {

              System.out.println("reading message " + msg + " ");
              output.println("OK");
            } else if (msg.length() > 12 && msg.charAt(12) == '1') {

              System.out.println("reading message " + msg + " ");

              // Should return IP address
              output.println(clientSocket.getInetAddress());
            } else if (msg.length() > 12 && msg.charAt(12) == '2') {

              System.out.println("reading message " + msg + " ");
              for (int i = 1; i <= 10; ++i) {

                output.println(i + " ");
              }

            } else if (msg.length() > 12 && msg.charAt(12) == '3') {

              System.out.println("reading message " + msg + " ");
              output.println("GOT IT");

            } else {
              System.out.println("*******************");

              // Invalid question from client, I guess.
              output.println("HUH?");
            }

          }

          // Make sure output is flushed to client.  It will be, but
          // just in case...
          output.flush();
        }

        // We're done with this client.  Close his socket.
        clientSocket.shutdownOutput();
        clientSocket.close();
        System.out.println("Closed client socket");
      }

      catch (IOException e) {
        System.out.println("accept failed");
        e.printStackTrace();
        System.exit(1);
      }

      System.out.println("Hello world");
    }

  }
}