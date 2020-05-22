package com.underdogdevs.stackoverflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestResourceFile {

    public static void main(String[] args) throws IOException {
        InputStream is = TestResourceFile.class.getResourceAsStream("/test.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}