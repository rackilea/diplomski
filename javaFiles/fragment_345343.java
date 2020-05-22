package com.example.gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.example.gson.ConfigData;
import com.google.gson.Gson;

public class GsonMain {

    private static final String jsonFile = "files/input.json";

    public static void main(String[] args) {
        String content = readFile(jsonFile);

        ConfigData conf = new Gson().fromJson(content, ConfigData.class);
        System.out.println(conf);
    }

    private static String readFile(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        StringBuilder content = new StringBuilder();

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                content.append(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return content.toString();
    }
}