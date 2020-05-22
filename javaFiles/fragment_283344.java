public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Hello Drews, how many total grades do you want to process?");
    int numberOfGrades = keyboard.nextInt();
    int[] storeGrades = new int[numberOfGrades];
    for (int i = 0; i < numberOfGrades; i++) {
        System.out.println("Please enter grade " + (i + 1) + ": ");
        storeGrades[i] = keyboard.nextInt();
    }
    System.out.println(getTotalScore(storeGrades));
}

public static int getTotalScore(int[] storeGrades) {
    int sum = 0;
    for (int i = 0; i < storeGrades.length; i++) {
        sum += storeGrades[i];
    }
    return sum;
}