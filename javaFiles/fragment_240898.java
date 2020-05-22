test string 1
test string 2
test string 3
test string 4


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {

        try {
            File input = new File("C:\\temp\\input.txt");
            File output = new File("C:\\temp\\output.txt");

            Scanner scanner = new Scanner(input);
            PrintWriter printer = new PrintWriter(output);
            while(scanner.hasNextLine()) {
                String string = scanner.nextLine();
                StringBuilder stringBuilder = new StringBuilder(200);
                for(char ch: string.toCharArray()) {
                    if(stringBuilder.length() > 0) stringBuilder.append(' ');
                    stringBuilder.append(String.format("%04x", (int)ch));
                }
                printer.write(stringBuilder.toString());                    
                printer.write("\r\n");
            }
            printer.flush();
            printer.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

}