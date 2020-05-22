package org.helios.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ShutdownHook {

    public static void main(String[] args) {
        Hook hook = new Hook();
        System.out.println("Running Main Application...");
        Runtime.getRuntime().addShutdownHook(hook);
        for (int i = 0; i < 50; i++) {
            //Pause for 4 seconds
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Going back to sleep");
        }
        System.out.println("Normal Exit...");
    }

    private static class Hook extends Thread {
        public void run() {
            try {
                FileWriter fstream = new FileWriter("c:\\out.txt");
                BufferedWriter out = new BufferedWriter(fstream);
                out.write("JVM Shutting down");
                out.close();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}