package com.example;
import java.io.*;
import java.util.Properties;

public class Main {
  public static void main(String[] args) throws Exception {
    Properties buildInfo = new Properties();
    InputStream is = Main.class.getResourceAsStream("buildinfo.properties");
    try {
      buildInfo.load(is);
    } finally {
      is.close();
    }

    System.out.println("Build target was " +
       buildInfo.getProperty("targetname", "<unknown>"));
  }
}