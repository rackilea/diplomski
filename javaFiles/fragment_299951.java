public class ScoresDemo {

    public static void main(String[] args) {
        double testScores[] = new double [5];
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < testScores.length; i++) {
            System.out.println("Enter some test scores: ");
            testScores[i] = scan.nextDouble();
        }
        // Now that we have a populated testScores array, call the constructor:
        TestScores scores = new TestScores(testScores);
        System.out.println("The average of the test scores is " + scores.averageScores());
    }
}