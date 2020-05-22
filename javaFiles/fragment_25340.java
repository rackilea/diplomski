import java.util.*;

        public class Practice2 {

public static void inputBirthDay(int number,String sentence,int number2)
{
 System.out.print("You were born on" + sentence + number
                    + "," + number2 + ". You're might old!");
}

            public static void main(String[] args){
                 Scanner console = new Scanner(System.in);
                System.out.println("On what day of the month were you born?");
                int number = console.nextInt();
                System.out.println("What is the name of the month in which you were born?");
                String sentence = console.next();
                System.out.println("During what year where you born?");
                int number2 = console.nextInt();
              inputBirthDay(number,sentence,number2);

            }
        }