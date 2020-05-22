public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the sample size: ");
    int[][] trials = new int[4][input.nextInt()];
    float[] averages = new float[trials.length];
    float min = Float.MAX_VALUE, max = Float.MIN_VALUE;
    for (int i = 0; i < trials.length; i++) {
        System.out.println(" Enter numbers for Trial: " + (i + 1));
        for (int j = 0; j < trials[i].length; j++) {
            System.out.println("Enter Sample # " + (j + 1) + ":");
            trials[i][j] = input.nextInt();
            averages[i] += trials[i][j];
        }
        averages[i] /= trials[0].length;

        if (averages[i] < min)
            min = averages[i];
        if (averages[i] > max)
            max = averages[i];
    }

    System.out.println("\tSample # \tTrial 1 \tTrial 2 \tTrial 3 \tTrial 4");

    for (int i = 0; i < trials[0].length; i++) {
        System.out.println("\t " + (i + 1) + "\t\t " + trials[0][i] + "\t\t " + trials[1][i] + "\t\t " + trials[2][i]
                + "\t\t " + trials[3][i]);
    }
    System.out.println("\t " + "average" + "\t " + averages[0] + "\t\t " + averages[1] + "\t\t " + averages[2]
            + "\t\t " + averages[3]);

    if (min == max)
        System.out.println("The trials match exactly");
    else if (max < 2 * min)
        System.out.println("The trials concur with each other");
    else
        System.out.println("The trials do not concur");

    input.close();
}