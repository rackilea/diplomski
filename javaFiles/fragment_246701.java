package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JavaCmd {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ProcessBuilder procBuilder = new ProcessBuilder("cmd.exe");
        Process proc = procBuilder.start();
        PrintWriter outToProc = new PrintWriter(proc.getOutputStream());
        final BufferedReader inFromProc = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        final BufferedReader errorFromProc = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Thread outputThread = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    try {
                        while(inFromProc.ready()) {
                            String line = inFromProc.readLine();
                            System.out.println(line);
                        }
                        while(errorFromProc.ready()) {
                            String line = errorFromProc.readLine();
                            System.err.println(line);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException("Error in output thread", e);
                    }
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        System.out.println("Output Thread interrupted -> Thread will terminate");
                        break;
                    }
                }
            }
        });

        outputThread.start();
        System.out.println("\n\nProxy shell is ready. Enter 'quit' to leave program.\n\n");
        System.out.flush();
        String line = null;
        while((line = reader.readLine()) != null) {
            if(line.equalsIgnoreCase("quit")) {
                System.out.println("Good Bye");
                break;
            }
            outToProc.println(line);
            outToProc.flush();
        }
        reader.close();
        outputThread.interrupt();
        proc.destroy();
    }

}