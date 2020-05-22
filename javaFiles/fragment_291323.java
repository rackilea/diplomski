import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BytesAt {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner read = new Scanner(new File("input.txt"));
    while (read.hasNextLine()) {
      String line = read.nextLine();
      String parts[] = line.split("bytes at");
      if(parts.length > 1) {
        System.out.println("Value as String: " + parts[1].trim());
        System.out.println("Value as Long: " + Long.parseLong(parts[1].trim()));
      }
    }
  }
}