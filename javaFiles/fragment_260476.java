import java.io.*;
class Test {
  public static void main(String[] _) throws Exception{
    FileInputStream inFile = new FileInputStream("test1.txt");
    FileOutputStream outFile = new FileOutputStream("test2.txt");

    byte[] buffer = new byte[128];
    int count;

    while (-1 != (count = inFile.read(buffer))) {
      // Dumb example
      for (int i = 0; i < count; ++i) {
        buffer[i] = (byte) Character.toUpperCase(buffer[i]);
      }
      outFile.write(buffer, 0, count);
    }

    inFile.close();
    outFile.close();
  }
}