import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    static Scanner in = new Scanner(System.in);

    public static String verifyName() {
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        Pattern p = Pattern.compile("[a-zA-Z0-9]*");
        Matcher m = p.matcher(name);
        if (!m.matches()) {
            System.out.println("Invalid Name");
            return verifyName();
        }
        return name;
    }

    public static void main(String args[]) {
        String result = verifyName();
        System.out.print(result);
    }
}