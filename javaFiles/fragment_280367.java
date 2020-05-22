package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer implements Runnable
{    
    public SimpleServer()
    {
        started = false;
        serverSocket = null;
    }

    public void start()
    {
        if(!started)
        {
            started = true;

            try
            {
                serverSocket = new ServerSocket(PORT);
                running = true;

                serverThread = new Thread(this);
                serverThread.start();

                System.out.println("Server started!\n");
            }catch(Exception e)
            {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    public void stop()
    {
        running = false;
        started = false;

        if(serverThread != null)
            serverThread.interrupt();
        serverThread = null;
    }

    public void run()
    {
        try
        {
            while(running)
            {
                try
                {
                    Socket client = serverSocket.accept();
                    System.out.println("Client Accepted!");

                    ClientHandler handler = new ClientHandler(client);

                    handler.sendMessage("Hello, SimpleClient!");
                    System.out.println("Sendeing client a message...");
                }catch(Exception e){e.printStackTrace();}
            }
        }catch(Exception e){e.printStackTrace();}
    }

    private boolean started;
    private boolean running;
    private ServerSocket serverSocket;
    private Thread serverThread;

    private static final int PORT = 8081;

    public static void main(String args[])
    {
        SimpleServer server = new SimpleServer();
        server.start();
    }

    public class ClientHandler implements Runnable
    {
        public ClientHandler(Socket socket)
        {
            this.socket = socket;

            try
            {
                writer = new PrintWriter(socket.getOutputStream());
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                running = true;

                runningThread = new Thread(this);
                runningThread.start();
            }catch(Exception e){e.printStackTrace(); disconnect();}
        }

        public void disconnect()
        {
            running = false;
            if(runningThread != null)
                runningThread.interrupt();
            runningThread = null;

            try
            {
                reader.close();
            }catch(Exception e){}
            reader = null;

            try
            {
                writer.close();
            }catch(Exception e){}
            writer = null;
            try
            {
                socket.close();
            }catch(Exception e){}
            socket = null;
        }

        public void sendMessage(String message)
        {
            if(running)
            {
                writer.println(message);
                writer.flush();
            }
        }

        public void run()
        {
            try
            {
                String message = "";
                while((message = reader.readLine()) != null && running)
                {
                    System.out.println("Message Recieved: " + message);
                }
            }catch(Exception e){e.printStackTrace(); disconnect();}
        }

        private Socket socket;
        private PrintWriter writer;
        private BufferedReader reader;

        private Thread runningThread;
        private boolean running;
    }
}