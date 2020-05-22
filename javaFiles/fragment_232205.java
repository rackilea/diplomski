import java.util.Scanner;

public class ScannerEx {

public static void main(String[] args) {
    Scanner scanner = new Scanner(new File("input.txt"));
    int count = 1;
    while(scanner.hasNextLine()) {
        String nextLine = scanner.nextLine();
        if(count % 4 == 0) {
             //Dollar amount in nextLine
        }
        count++;
    }

 }
}