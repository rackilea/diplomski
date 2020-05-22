import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileInputExample {
  public static void main(String[] args) {
    File file = new File("input.txt");
    try {
      Scanner scanner = new Scanner(file);
      int n = scanner.nextInt(); // This reads the 3 in your example
      for (int line = 1; line <= n; line++) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // Do something with a and b like store them in ArrayLists or something
        System.out.println(String.format("A: %d, B: %d", a, b));
      }
      scanner.close();
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}