public class QuizGame {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        Quiz q = new Quiz();
        player p = new player();
        q.gameStart();
        p.getAnswers();
        q.checkScore(tar, correctAnswers);
        q.ShowScore();
    }
}