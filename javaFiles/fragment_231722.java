for (int i = 0; i < 4; i++) {
    System.out.println("Please input a number between zero to 3");
    // use input and don't advance the scanner every time
    int input = sc.nextInt();

    if (input == 0) {
        System.out.println("You have selected " + right);
    }
    if (input == 1) {
        System.out.println("You have selected " + left);
    }

    // so on and so forth

}