public static double[] getscores() {
    int numscores = 8;
    double score[] = new double[numscores];
    for (int a = 0; a < numscores; a++) {
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter a score");
        try{
            score[a] = ip.nextDouble();
        } catch(InputMismatchException ime) {
            System.out.println("Wrong input");
            a--;
        }
    }
    return score;
}