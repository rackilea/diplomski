public class DriverTestBlah {
  public static void main(String [] args){

    Scanner input = new Scanner(System.in);
    char[] correctAnswers = {'A','D','C','A','A','D','B',
    'A','C','A','D','C','B','A','B'};
    char[] userAnswer = new char[correctAnswers.length];

    for(int i = 0; i < 15; i++) //print question numbers/takes user input
    {
      System.out.println("Question " + (i + 1) + ":");
      userAnswer [i] = input.nextLine().charAt(0);
    }//end of for loop

    System.out.println("number correct: " + total_correct_answers(correctAnswers, userAnswer));

    input.close();
  }//end of main

  public static int total_correct_answers(char []correctAnswers,char [] userAnswer) {
    int number_correct = 0;

    for (int i = 0; i < 15; i++){
        if(correctAnswers[i] == userAnswer[i]){
            number_correct++;
        }
    }//end of for loop
    return number_correct;
  }//end of correct method
}//end of class