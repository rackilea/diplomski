package gametester;

import static gametester.GameTester.questionCount;
import java.util.Random;

public class Multiplier{

    public static int product;

  public Multiplier(){ }

  public static String generateProblem(){
    questionCount++;
    Random r = new Random();
    int term1 = r.nextInt(11);
    int term2 = r.nextInt(11);
    product = term1 * term2;
    String s = String.valueOf(questionCount) + ") How much is " + term1 + " times " + term2 + "?";
    return s;
  }

  public static int checkAnswer(){
      return product;
  }
}