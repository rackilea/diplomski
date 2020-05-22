import java.util.Scanner;

public class StringReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user1 = "", user2 = "", user3 = "";
        int count = 0;
        while(user1.equals("") || user1.length() < 7) {
            System.out.println("Input a string");
            user1 = input.nextLine();
        }
        if(!user1.equals("")) {
            System.out.println("now input a letter to be replaced");
            String letter = input.next();
            user2 = user1.replace(letter, "-");
            user3 = user1.replace(letter, "");
            System.out.println(user2);
            System.out.println(user3);
            count += (user1.length() - user3.length());
            System.out.println("letter was found to be present "+count+" times");
        }
    }
}