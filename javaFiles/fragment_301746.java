public static void main(String[] args) {
  final Scanner scan = new Scanner(System.in);

  final int[] testScores = new int[3]; // use an array here
  Arrays.fill(testScores, -1); // set all to -1 to know if we already got a proper input

  for (int i = 0; i < testScores.length; ++i) { // for loop simplifies the whole thing a lot
    while ((testScores[i] < 0) || (testScores[i] > 100)) {
      System.out.println("Please enter Test " + (i + 1) + ":");
      testScores[i] = scan.nextInt();
    }
  }   

  int exam = -1; // Final is a bad name, because final is a reserved word
  while ((exam < 0) || (exam > 100)) {
    System.out.println("Please enter Final Exam:");
    exam = scan.nextInt();
  }

  Arrays.sort(testScores); // automatically sorts the entry from lowest to highest
  final double AVG = (testScores[testScores.length - 1] + testScores[testScores.length - 2]) * 0.3 + exam * 0.4; // therefore the best grades are the last two entries

  if (AVG >= 90) {
    System.out.println("A " + AVG);
  } else if (AVG >= 80) {
    System.out.println("B " + AVG);
  } else if (AVG >= 70) {
    System.out.println("C " + AVG);
  } else if (AVG >= 60) {
    System.out.println("D " + AVG);
  } else {
    System.out.println("F " + AVG);
  }
}