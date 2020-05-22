// Client.java: The client sends the input to the server and receives
// result back from the server
import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
// Main method
public static void main(String[] args)
{
  // IO streams
  DataOutputStream toServer;
  DataInputStream fromServer;

try
{
  // Create a socket to connect to the server
  Socket socket = new Socket("localhost", 8000);

  // Create input stream to receive data
  // from the server
  fromServer = new DataInputStream(socket.getInputStream());

  // Create a output stream to send data to the server
  toServer = new DataOutputStream(socket.getOutputStream());

    Scanner scan= new Scanner (System.in);

  // Continuously send radius and receive area
  // from the server
  while (true)
  {
    // Read the m/s from the keyboard
    System.out.print("Please enter a speed in meters per second: ");
    double meters=scan.nextDouble();

    // Send the radius to the server
    toServer.writeDouble(meters);
      toServer.flush();


    // Convert string to double
    double kilometersPerHour = fromServer.readDouble();

    // Print K/h on the console
    System.out.println("Area received from the server is "
      + kilometersPerHour);
  }
}
catch (IOException ex)
{
  System.err.println(ex);
}
  }
}