package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Copy {

    private static final String PING_LOCALHOST = "ping localhost";

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ProgressBar progressBar = new ProgressBar();
        progressBar.showProgress();
        // first command
        runCommand(progressBar, PING_LOCALHOST, 25);
        runCommand(progressBar, PING_LOCALHOST, 50);
        runCommand(progressBar, PING_LOCALHOST, 75);
        runCommand(progressBar, PING_LOCALHOST, 100);

    }

    private static void runCommand(ProgressBar progressBar, String command, int barValue) throws InterruptedException {
        CopyThread copyThread = new Copy().new CopyThread(command);
        copyThread.start();
        // wait for thread to die
        copyThread.join();
        progressBar.updatePercent(barValue);
    }

    private class CopyThread extends Thread {
        private String cmd;

        public CopyThread(String command) {
            this.cmd = command;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                String line;
                Process p = Runtime.getRuntime().exec(cmd);
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                input.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }

    }

}