package com.loknath.lab;

 import java.io.File;
 import java.io.IOException;

public class Demo {
public static void main(String[] args) throws IOException,
        InterruptedException {

    String applicationName = "x";
    String key = "x", value = "c//as//xyx.exe";

    File application = new File(applicationName);

    if (application.exists()) {

        Process p = Runtime.getRuntime().exec(application.toString());
        p.waitFor();

    } else {

        System.setProperty(key, value);
        System.out.println(System.getenv("CLASSPATH"));
    }

} 
  }