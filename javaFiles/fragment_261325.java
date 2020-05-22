import java.util.Random;
import javax.swing.JOptionPane;

public class Main{

  public static void main(String[] args) {

      boolean correctAnswer;
      Random number = new Random();
      int nmb1;
      int nmb2;
      int multi;


    while (true) {
        nmb1 = number.nextInt(10) + 1;
        nmb2 = number.nextInt(10) + 1;
        multi = nmb1 * nmb2;

        // read the user's input ...
        do {
            correctAnswer = multiplication(nmb1,nmb2,multi);
        }
        while (correctAnswer != true);
        // .. and repeat until the user types the correct answer

        JOptionPane.showMessageDialog(null, "Right");
      }
   }


  public static boolean multiplication(int number1,int number2,int answer)
  {

      int question;

         question = Integer.parseInt(JOptionPane.showInputDialog("How much is" + number1 + "*" + number2));

          if (question != answer) {
              JOptionPane.showMessageDialog(null, "Wrong, try again");

              return false;
          }

      return true;

  }

}