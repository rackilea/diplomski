public void test(Scanner input, boolean temp) {

    int choice = input.nextInt();

    if (choice == 1)
        System.out.println("Continue code");
    else if (choice == 2) {
        if (temp) {
            test(input, temp);

        } else {
            System.out.println("Continue code");
        }
    }

}