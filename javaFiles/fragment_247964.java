package com.java.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Client() {
        try {
            Socket socket;
             socket = new Socket("localhost",2222);

            // InputStream in = socket.getInputStream();
            while (true) {
//              socket = new Socket("localhost", 2222);
                System.out.println("Socket - " + socket.getLocalPort());
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println("Hi Server");
//              Thread.sleep(2000);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                System.out.println("Waiting for server reply..");
                System.out.println(br.readLine());
                System.out.println("Got reply from server..");
                // pw.flush();
            }
        } catch (IOException/* | /*InterruptedException*/ e) {
            e.printStackTrace();
            System.out.println("Client Constructor Exception");
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
    }

}