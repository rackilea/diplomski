package com.sandbox;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Sandbox {

    public static void main(String[] args) throws URISyntaxException, IOException {
        new Sandbox().run();
    }

    private void run() throws URISyntaxException, IOException {
        URL resource = Sandbox.class.getResource("/my.txt");
        File file = new File(resource.toURI());
        String s = FileUtils.readFileToString(file);
        System.out.println(s);
    }


}