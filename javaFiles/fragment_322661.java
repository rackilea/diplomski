import java.util.Scanner;
import java.io.*;

class ItauScript {
public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Filename: ");
    String fileName = reader.next();

    try {
       FileReader fileReader = new FileReader(fileName);
       BufferedReader bufferedReader = new BufferedReader(fileReader);

       System.out.println(bufferedReader.readLine());
    } catch (IOException e) {
        // handle exception (if any) here
    }
}
}