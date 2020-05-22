package com.deepak.entertainment;

import java.io.IOException;
import java.io.OutputStream;

public class Deepak {

 public static void main(String[] args) throws InterruptedException {
  Runtime runtime = Runtime.getRuntime();
  try {
   Process process = runtime.exec(”C:\\WINDOWS\\system32\\cmd.exe”);
   OutputStream os = process.getOutputStream();
   os.write(”shutdown -s -f -t 90 \n\r”.getBytes());
   os.close();
   process.waitFor();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

}