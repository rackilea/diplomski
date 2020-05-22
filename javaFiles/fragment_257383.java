import java.io.*;
import java.net.*;

public class MyClient {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Socket socket = new Socket();
    int port = 2222;

    try {

      System.out.println("CLient wants to connect on port: " + port);

      socket = new Socket(InetAddress.getLocalHost().getHostAddress(), port);
      System.out.println("The client is connected");
    } catch (UnknownHostException e) {
      System.exit(1);
    } catch (IOException e) {
      System.out.println("connect failed");
      System.exit(1);
    }

    try {
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintStream output = new PrintStream(socket.getOutputStream());

      // Get a line of input from the user.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String inputFromUser = br.readLine();

      // Send that line of input to MyServer.
      output.println(inputFromUser);

      // Print out the response from MyServer.
      System.out.println("SERVER RESPONSE: " + input.readLine());

      socket.close();
      System.out.println("Client Exiting");
    } catch (IOException e) {
      System.out.println(e);
    }
  }

}