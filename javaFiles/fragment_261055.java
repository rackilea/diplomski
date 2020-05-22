import java.util.Scanner;

public class ScannerTest {
   private static final String TXT = "ScannerTest.txt";

   public static void main(String[] args) {
      Scanner outerScan = 
           new Scanner(ScannerTest.class.getResourceAsStream(TXT));
      while (outerScan.hasNextLine()) {
         String line = outerScan.nextLine().trim();
         if (!line.isEmpty()) {
            Scanner innerScan = new Scanner(line);
            while (innerScan.hasNext()) {
               String nextToken = innerScan.next();
               System.out.println("Token: " + nextToken);
            }
            innerScan.close();
         }
      }
      outerScan.close();
   }
}