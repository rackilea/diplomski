import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SO {
  public static void scanner() throws FileNotFoundException {
    System.out.println("Reading with the Scanner Class:");
    Scanner scanner= new Scanner(new File("target.txt"));
    while(scanner.hasNext()) {
      try {
        System.out.println("A Byte:"+scanner.nextByte());
      } catch(InputMismatchException e) {
        System.out.println("Not a byte:"+scanner.next());
      }
    }
    scanner.close();
  }

  public static void stream() throws IOException {
    System.out.println("Reading with the FileInputStream Class:");
    FileInputStream d = new FileInputStream("target.txt");
    int b = -1;
    while((b = d.read()) != -1) {
      System.out.print((byte)b+" ");
    }
    d.close();
    System.out.println();
  }

  public static void main(String...args) throws IOException {
    scanner();
    stream();
  }
}