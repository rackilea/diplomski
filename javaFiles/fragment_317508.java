package de.scrum_master.stackoverflow.q55475971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient implements AutoCloseable {
  private Socket echoSocket;
  private PrintWriter out;
  private BufferedReader in;

  public EchoClient(String hostName, int portNumber) throws IOException {
    this(new Socket(hostName, portNumber));
  }

  public EchoClient(Socket echoSocket) throws IOException {
    this.echoSocket = echoSocket;
    out = new PrintWriter(echoSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
    System.out.printf("%-25s - Echo client started%n", Thread.currentThread());
  }

  public String sendMessage(String msg) throws IOException {
    System.out.printf("%-25s - Sending message: %s%n", Thread.currentThread(), msg);
    out.println(msg);
    return in.readLine();
  }

  @Override
  public void close() throws Exception {
    System.out.printf("%-25s - Shutting down echo client%n", Thread.currentThread());
    if (out != null) out.close();
    if (in != null) in.close();
    if (echoSocket != null) echoSocket.close();
  }
}