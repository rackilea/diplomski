// put this above main() - this way you can use it without ever defining a `Scanner` object again
static Scanner in = new Scanner(System.in);

public static void main(String[] args) {

  // store number of scores to enter
  int numScores = 0;

  // input number of scores to enter
  System.out.print("How many scores would you like to enter? ");
  numScores = in.nextInt();

  // store sum of scores
  int scoreTotal = 0;

  // input scores
  for(int i = 0; i < numScores; i++)
    scoreTotal += in.nextInt();

  // print count, sum, and average of scores
  System.out.printf("\nScore count: %d", numScores);
  System.out.printf("\nScore total: %d", scoreTotal);
  System.out.printf(\n Average score: %d", scoreTotal/numScores);
}