public static void main(String args[]) {
    int count = 0;
    int input = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number: ");
    input = sc.nextInt();

    while (input < 100 || input > 200) {
        System.out.println("Enter number between 100 to 200");
        input = sc.nextInt();
        count++;
    }
    System.out.println(input + " fits " + count(input) + " times");
}


private static int count(int input) {
    int result = 0;
    int temp = input;
    while (temp <= 1000) {
        if (temp >= 500) {
            result++;
        }
        temp += input;
    }
    return result;
}