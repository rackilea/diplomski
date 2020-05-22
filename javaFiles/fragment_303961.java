import java.util.Scanner;

public class RepeatAdditionQuiz {

public static void main(String[] args) {
    // TODO Auto-generated method stub
    int number1 = (int) (Math.random() * 10);
    int number2 = (int) (Math.random() * 10);

    Scanner input = new Scanner(System.in);
    System.out.print("What is " + number1 + " + " + number2 + " : ");
    int answer = input.nextInt();
    int count = 1;
    do {

        if (number1 + number2 != answer) {
            System.out.print("Try again, What is " + number1 + " + " + number2 + " : ");
            answer = input.nextInt();
        } else{
            System.out.println("You're correct ");
            break;
        }
        count++;
    } while (count < 3);
    System.out.println("Your trails ended ");

}

}