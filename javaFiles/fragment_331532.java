package com.mumz.test.executable.jar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JustPrint {    
    private static String         logFile   = "backooopLog.txt";
    private static BufferedWriter   logFileWriter;
    private static void initLog() {
            File logFileObj = new File(logFile);
        try {
            FileWriter fileWriter = new FileWriter(logFileObj);
            logFileWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        initLog();
        String message = "hello word";
        System.out.println(message);
        try {
            if (logFileWriter != null) {
                logFileWriter.write(message);
                logFileWriter.flush();
            }
            Runtime.getRuntime().exec("echo " + message);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally{
            try {
                logFileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}