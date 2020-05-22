import java.util.Scanner;
public class MathTest {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("What is 5 times 4? ");
        String question;
        question = user_input.next();
        if (question.equals("20"))
            System.out.println("Correct!");
        if (!"20".equals(question))
            System.out.println("Incorrect!");
    }
}