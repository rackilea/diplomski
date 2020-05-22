public class QuizGame {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        Quiz q = new Quiz();
        player p = new player();
        q.gameStart();
        q.checkScore(p.getAnswers(), Quiz.correcAnswers); //Pass directly the arrays returned by the calls p.getAnswers() and Quiz.correcAnswers without assign that returns to variables
        q.ShowScore();
    }
}