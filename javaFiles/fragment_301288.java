public class QuizScore {
    private int qs[];
    static EasyReader console = new EasyReader();

    public QuizScore(int num) {

        qs = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter in your scores: ");
            try {
                qs[i] = console.readInt();
            } catch (Exception ex) {
                // console.ignore();
            }
        }
        console.close();
    }

    public static void main(String args[]) {
        System.out.println("How many numbers are in your array?");
        int num = console.readInt();
        new QuizScore(num);
    }

}