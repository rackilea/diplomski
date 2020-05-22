package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient implements Runnable
{
    public SimpleClient()
    {
        try
        {
            socket = new Socket("127.0.0.1", PORT);
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

                System.out.println("Sending a response!");
                sendMessage("Hello, SimpleServer!");
            }
        }catch(Exception e){e.printStackTrace(); disconnect();}
    }

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private Thread runningThread;
    private boolean running;

    private static final int PORT = 8081;

    public static void main(String args[])
    {
        new SimpleClient();
    }
}