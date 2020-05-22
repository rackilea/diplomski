public static void main(String[] args) {
    System.out
            .println("This program will multiply 2 one dimension arrays of any length. \n The length and contents of the array is entered from the keyboard.");
    System.out.println("Enther the data for the first array. ");

    System.out
            .println("Enther the length of the array (remember arrays being counting at 0, not 1:");

    int a = 0;
    Scanner keyboard = new Scanner(System.in);
    a = keyboard.nextInt();
    int[] firstArray = new int[a];
    System.out
            .println("Enter the elements of the first array(remember arrays begin counting at 0, not 1");
    for (int elements = 0; elements < firstArray.length; elements++) {

        firstArray[elements] = keyboard.nextInt();
    }

    System.out.println("Enter the data for the second array. ");
    System.out
            .println("Enter the elements of the second  array(remember arrays begin counting at 0, not 1");
    int[] secondArray = new int[a];

    for (int elements = 0; elements < secondArray.length; elements++) {

        secondArray[elements] = keyboard.nextInt();
    }
    double[] thirdArray = new double[a];

    for (int i = 0; i < firstArray.length; i++) {
        thirdArray[i] = firstArray[i]*secondArray[i];
    }

    for (int i = 0; i < thirdArray.length; i++)
        System.out.println(thirdArray[i]);
}