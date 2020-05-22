package de.scrum_master.stackoverflow.q55475971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer implements AutoCloseable {
  private ServerSocket serverSocket;

  public EchoServer(int portNumber) throws IOException {
    this(new ServerSocket(portNumber));
  }

  public EchoServer(ServerSocket serverSocket) throws IOException {
    this.serverSocket = serverSocket;
    listen();
    System.out.printf("%-25s - Echo server started%n", Thread.currentThread());
  }

  private void listen() {
    Runnable listenLoop = () -> {
      System.out.printf("%-25s - Starting echo server listening loop%n", Thread.currentThread());
      while (true) {
        try {
          echo(serverSocket.accept());
        } catch (IOException e) {
          System.out.printf("%-25s - Stopping echo server listening loop%n", Thread.currentThread());
          break;
        }
      }
    };
    new Thread(listenLoop).start();
  }

  private void echo(Socket clientSocket) {
    Runnable echoLoop = () -> {
      System.out.printf("%-25s - Starting echo server echoing loop%n", Thread.currentThread());
      try (
        Socket socket = clientSocket;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
      ) {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
          out.println(inputLine);
          System.out.printf("%-25s - Echoing back message: %s%n", Thread.currentThread(), inputLine);
        }
        System.out.printf("%-25s - Stopping echo server echoing loop%n", Thread.currentThread());
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
    new Thread(echoLoop).start();
  }

  @Override
  public void close() throws Exception {
    System.out.printf("%-25s - Shutting down echo server%n", Thread.currentThread());
    if (serverSocket != null) serverSocket.close();
  }
}