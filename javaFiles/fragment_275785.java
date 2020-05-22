public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new FileInputStream(new File("file.txt")));
    PrintWriter p = new PrintWriter("Class_report.txt");
    int x = 0, num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
    double avg1 = 0, avg2 = 0, avg3 = 0, avg4 = 0, avg5 = 0, avg6 = 0;
    int[] total = new int[30];
    int[] number = new int[6];
    int[][] subjects = new int[30][6];
    double[] average = new double[6];
    for (int i = 0; i < 30; i++) {
        for (int j = 0; j < 6; j++) {
            x = x + scan.nextInt();
        }
        total[i] = x;
        x = 0;
    }

    scan = new Scanner(new FileInputStream(new File("file.txt")));
    for (int i = 0; i < 30; i++) { //Exception starts appearing from this line.
        for (int j = 0; j < 6; j++) {
            subjects[i][j] = scan.nextInt();
        }
    }
    for (int i = 0; i < 30; i++) {
        avg1 = avg1 + (double) subjects[i][0];
        avg2 = avg2 + (double) subjects[i][1];
        avg3 = avg3 + (double) subjects[i][2];
        avg4 = avg4 + (double) subjects[i][3];
        avg5 = avg5 + (double) subjects[i][4];
        avg6 = avg6 + (double) subjects[i][5];
    }
    average[0] = avg1 / 30;
    average[1] = avg2 / 30;
    average[2] = avg3 / 30;
    average[3] = avg4 / 30;
    average[4] = avg5 / 30;
    average[5] = avg6 / 30;
    for (int i = 0; i < 30; i++) {
        if (subjects[i][0] >= 50) {
            num1++;
        }
        if (subjects[i][1] >= 50) {
            num2++;
        }
        if (subjects[i][2] >= 50) {
            num3++;
        }
        if (subjects[i][3] >= 50) {
            num4++;
        }
        if (subjects[i][4] >= 50) {
            num5++;
        }
        if (subjects[i][5] >= 50) {
            num6++;
        }
    }
    number[0] = num1;
    number[1] = num2;
    number[2] = num3;
    number[3] = num4;
    number[4] = num5;
    number[5] = num6;
    scan = new Scanner(new FileInputStream(new File("file.txt")));
    for (int i = 0; i < 30; i++) {
        for (int j = 0; j < 6; j++) {
            x = x + scan.nextInt();
        }
        total[i] = x;
        x = 0;
    }
    for (int i = 0; i < 30; i++) {
        p.println("Total score of student #" + (i + 1) + ": " + total[i]);
    }
    for (int i = 0; i < 6; i++) {
        p.println("Number of passing student in subject#" + (i + 1) + ": " + number[i]);
    }
    for (int i = 0; i < 6; i++) {
        p.println("Average score in subject#" + (i + 1) + ": " + average[i]);
    }
    p.close();
}