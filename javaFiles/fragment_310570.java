public static void main(String[] args) {
    System.out.println("How many elements would you like the array to have?");
    Scanner input = new Scanner(System.in);
    int arraySize = input.nextInt();
    int value[] = new int[arraySize];

    System.out.println("Enter numbers for the array.");
    Lab1 lab1 = new Lab1();
    for (int i = 0; i < value.length; i++) {
        value[i] = input.nextInt();   
    }
    System.out.println(lab1.minGap(value));
}