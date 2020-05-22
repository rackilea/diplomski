import java.io.*;

public class Multithread {

  public static void main(String[] args) throws FileNotFoundException {
    String fileName = "out.txt";
    new PrintWriter(fileName).close();//to clear the text of the file
    Runnable printA = new PrintChar('a', 500);
    Runnable print100 = new PrintNum(500);

    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(print100);

    thread1.start();
    thread2.start();
  }
}

class PrintChar implements Runnable {
  private char charToPrint;
  private int times;

  public PrintChar(char c, int t) {
    charToPrint = c;
    times = t;
  }

  @Override
  public void run() {
    String fileName = "out.txt";
    try {
      synchronized (Multithread.class) {//to writ by one thread 
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outputStream = new PrintWriter(bw);
        for (int i = 0; i < times; i++) {
          outputStream.print(charToPrint);
        }
        outputStream.close();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class PrintNum implements Runnable {
  private int lastNum;

  public PrintNum(int n) {
    lastNum = n;
  }

  @Override
  public void run() {
    String fileName = "out.txt";
    try {
      synchronized (Multithread.class) {//to write by one thread
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outputStream = new PrintWriter(bw);
        for (int i = 1; i <= lastNum; i++) {
          outputStream.print(" " + i);
        }
        outputStream.close();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}