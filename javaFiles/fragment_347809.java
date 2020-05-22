import org.antlr.runtime.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        REPLParser parser = new REPLParser();
        while(true) {
            System.out.print("\n> ");
            String input = keyboard.nextLine();
            if(input.equals("quit")) {
                break;
            }
            parser.process(input);
        }
        System.out.println("\nBye!");
    }
}