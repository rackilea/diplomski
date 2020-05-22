package com.stack.overflow.works.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author sarath_sivan
 *
 */

public class FileIOService {

    private static final String BLANK_SPACE = " ";

    public static void main(String[] args) {
        FileIOService.run();
    }

    public static void run() {
        long startTime = System.currentTimeMillis();
        String fileName = "C:/Users/sarath_sivan/Desktop/input.txt";
        FileIOService.display(split(getContent(fileName)));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Total Time: "+ elapsedTime + " Milliseconds...");
    }

    public static void display(List<String> splitsList) {
        for (String split: splitsList) {
            System.out.println(split);
        }
    }

    public static List<String> split(String content) {
        List<String> splitsList = new ArrayList<String>(Arrays.asList(content.split(BLANK_SPACE)));
        return splitsList;
    }

    public static String getContent(String fileName) {
        File file = new File(fileName);
        String content = null;
        try {
            content = FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}