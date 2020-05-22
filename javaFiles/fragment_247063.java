package com.Kaelinator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class ServerManager2 {

  static BufferedWriter writer;
  static BufferedReader reader;
  static boolean Running = false;
  //static String command = "C:/Users/Kael/Desktop/minecraftserver/RUN.bat";
  static String command = "C:/Users/Owner/Desktop/rekt/Run.bat";
  static String shutDown = "C:/Windows/System32/shutdown.exe -r -t 0";



  public static void main(String[] args) throws IOException {
    runServer();
    while (Running) {
      chatChecker();
    }

    Commands();

  }




  public static void chatChecker() {
    LocalDateTime now = LocalDateTime.now();
    int hour = now.get(ChronoField.HOUR_OF_DAY);
    int minute = now.get(ChronoField.MINUTE_OF_HOUR);
    int second = now.get(ChronoField.SECOND_OF_MINUTE);

    String hourSyntax = Integer.toString(hour);
    String minuteSyntax = Integer.toString(minute);
    String secondSyntax = Integer.toString(second);

    String chatChecker = "[" + hourSyntax + ":" + minuteSyntax + ":" + secondSyntax +
            "] [Server thread/INFO]: ";
    System.out.println(chatChecker);
  }

  public static void sleepThread(long time) {

    try {
      Thread.sleep(time * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }


  public static void runServer() throws IOException {
    Process process = Runtime.getRuntime().exec(command);
    writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    process.getInputStream();

    reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
  }

  public static void readOutput() throws IOException {
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }

  public static void Commands() throws IOException {

    Running = true;

    try {

      sleepThread(3);
      writer.append("say SERVER STARTED");
      writer.newLine();
      writer.flush();
      sleepThread(14100);
      writer.append("say restarting in 5 minutes");
      writer.newLine();
      writer.flush();
      sleepThread(60);
      writer.append("say restarting in 4 minutes");
      writer.newLine();
      writer.flush();
      sleepThread(60);
      writer.append("say restarting in 3 minutes");
      writer.newLine();
      writer.flush();
      sleepThread(60);
      writer.append("say restarting in 2 minutes");
      writer.newLine();
      writer.flush();
      sleepThread(60);
      writer.append("say restarting in 1 minutes");
      writer.newLine();
      writer.flush();
      sleepThread(30);
      writer.append("say restarting in 30 seconds");
      writer.newLine();
      writer.flush();
      sleepThread(20);
      writer.append("say restarting in 10 seconds");
      writer.newLine();
      writer.flush();
      sleepThread(5);
      writer.append("say restarting in 5 seconds");
      writer.newLine();
      writer.flush();
      sleepThread(1);
      writer.append("say restarting in 4 seconds");
      writer.newLine();
      writer.flush();
      sleepThread(1);
      writer.append("say restarting in 3 seconds");
      writer.newLine();
      writer.flush();
      sleepThread(1);
      writer.append("say restarting in 2 seconds");
      writer.newLine();
      writer.flush();
      sleepThread(1);
      writer.append("say restarting in 1 second");
      writer.newLine();
      writer.flush();
      writer.append("stop");
      writer.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}