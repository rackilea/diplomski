public static void main(String... ars) {

    System.out.println("enter the length of arrays");
    Scanner sc = new Scanner(System.in);

    int len = sc.nextInt();


    int numbersA[] = new int[len];
    int numbersB[] = new int[len];
    int numbersC[] = new int[len];

    Random rand = new Random();

    System.out.println("enter the values of first array");
    for (int i = 0; i < numbersA.length; i++) {
        numbersA[i] = sc.nextInt();
    }
    System.out.println(Arrays.toString(numbersA));

    System.out.println("enter the values of second array");
    for (int i = 0; i < numbersB.length; i++) {
        numbersB[i] = sc.nextInt();
    }

    System.out.println(Arrays.toString(numbersB));


    out.println("The multiplication of the two arrays (the first one with the last one and consecutively) are: ");
    for (int i = 0; i < numbersC.length; i++) {
        numbersC[i] = numbersA[i] * numbersB[(numbersB.length)-1-i];
    }

    System.out.println(Arrays.toString(numbersC));
}