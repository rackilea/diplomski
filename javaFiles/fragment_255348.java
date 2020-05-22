package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compile {

    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("javac", "hello/*.java");
        builder.directory(new File("C:\\Users\\carlitos\\Desktop"));

        Process pro = builder.start();
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(pro.getErrorStream()));

        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();

        // executing...
        ProcessBuilder builder1 = new ProcessBuilder("java", "hello.Main", "carlitosWay");
        builder1.directory(new File("C:\\Users\\carlitos\\Desktop"));

        Process pro1 = builder1.start();
        in = new BufferedReader(new InputStreamReader(pro1.getInputStream()));

        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }
}