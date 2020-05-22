import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) throws Exception{
        FileReader file = new FileReader("music.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            for(int i = 0; i < tokens.length; i++){
                String[] elements = tokens[i].split("=");
                System.out.println(elements[0] + ": " + elements[1]);
            }
            System.out.println();
        }
        scanner.close();
    }
}