/* 
* Created by jHeck
*/
// Server.java: The server accepts data from the client, processes it
// and returns the result back to the client
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class Server 
{
// Main method
public static void main(String[] args)
{ 
  try
{
  // Create a server socket
  ServerSocket serverSocket = new ServerSocket(8000);

  // Start listening for connections on the server socket
  Socket socket = serverSocket.accept();

  // Create data input and output streams
  DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());


  // Continuously read from the client and process it,
  // and send result back to the client
  while (true)
  {

    // Convert string to double
    double meters = inputFromClient.readDouble();

    // Display radius on console
    System.out.println("Meters received from client: "
      + meters);

    // Compute area
    double conversionToKilometers = (meters/1000)*3600;

    // Send the result to the client
    outputToClient.writeDouble(conversionToKilometers);

    //Create double formater
    DecimalFormat format = new DecimalFormat("0.00");
    String formatedCTK = format.format(conversionToKilometers);

    // Print the result to the console
    System.out.println("Kilometers per hour = "+ formatedCTK);
  }
}
catch(IOException ex)
{
  System.err.println(ex);
}
  }
}