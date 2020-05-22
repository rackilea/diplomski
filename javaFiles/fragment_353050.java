public class Punctuation
{
  private int x;
  private String[] quizQuestion;
  private int score;
  ...

  public Punctuation()
  {
    this.x = 0;
    this.quizQuestion = {""}
    this.score = 0
    ...
  }

  public void startQuiz()
  {
    //Instructions and introduction to the quiz

    JOptionPane.showMessageDialog(null, "You chose to test your writing skills--specifically, errors with punctuation.");
    JOptionPane.showMessageDialog(null, "Each question has the answer choices \"(A),\" \"(B),\" \"(C),\" and \"(D),\" each of which, except for \"(D),\" corresponds to \na part of a sentence that follows it.  Choose the letter that has text that contains an error.\nIf you believe there is no error, choose \"(D).\"");
    JOptionPane.showMessageDialog(null, "Here's an example question: \n [(A) At 1912] the ship [(B) HMS _Titanic_] sank amid lofty [(C) claims made] by the White Star Line. [(D): no error] \n \n As you can see, \"(A)\" contains the error because it uses an incorrect preposition.");
    JOptionPane.showMessageDialog(null, "To answer a question, simply type the letter of the answer choice that you believe is incorrect. \n Do NOT type the parentheses.");

    //Counts number of questions correct
    //Gives the user the questions

    for(x = 0; x < 15; x++)
    {
    ...
  }
}