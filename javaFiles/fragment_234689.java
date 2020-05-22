package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamRedirector extends Thread {

  private InputStream inputStream;
  private OutputStream outputStream;

  public StreamRedirector(InputStream inputStream, OutputStream outputStream) {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
  }

  public void run() {
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String line = null;
    try {
      while ((line = bufferedReader.readLine()) != null) {
        outputStreamWriter.write(line + "\n");
        outputStreamWriter.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}