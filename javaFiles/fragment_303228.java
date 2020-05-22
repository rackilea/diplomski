public class QuizGame {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        Quiz q = new Quiz();
        player p = new player();
        q.gameStart();
        tar = p.getAnswers();//Assign the int[] returned by p.getAns
        q.checkScore(tar, Quiz.correcAnswers); // get the static array correctAnswers and pass it as an argument of the method
        q.ShowScore();
    }
}