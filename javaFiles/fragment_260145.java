import java.util.Scanner;

public class InputScan {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String a;
        System.out.print("enter string: ");
        String pattern = "\\(\\d+,\\d+\\)"; // Its regex
        // For white spaces as you commented use following regex
        // String pattern = "\\([\\s+]?\\d+[\\s+]?,[\\s+]?\\d+[\\s+]?\\)";
        if ((a = input.findInLine(pattern)) != null){
            System.out.println(a);
        }
    }
}