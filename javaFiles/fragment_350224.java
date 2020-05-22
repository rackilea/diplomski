public static int intInput(String prompt, String error) {

    int intInput = 0;
    Scanner sc = new Scanner(System.in);
    do {
        try {
            System.out.println("Enter an int");
            intInput = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(error);
            intInput = 0;
        }
    } while (intInput == 0);

    return intInput;
}