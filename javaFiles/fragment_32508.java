import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileInputExample {
  public static void main(String[] args) {
    File file = new File("input.txt");
    try {
      Scanner scanner = new Scanner(file);
      scanner.nextLine(); // skip the 3 on the first line
      while (scanner.hasNextLine()) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(String.format("A: %d, B: %d", a, b));
      }
      scanner.close();
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}