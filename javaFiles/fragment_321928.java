public static void main(String[] args) {
    int[] numbers = new int[10];
    System.out.printf("Enter %d integers : ", numbers.length);
    int sum = 0;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < numbers.length; i++) {
        sum += (numbers[i] = sc.nextInt());
    }
    double average = sum / (double) numbers.length;
    System.out.println("average : " + average);
}