while (keepGoing) {
    while (numbers < 1 || numbers > 12) {
        System.out.print("Enter an integer between 1 and 12:");
        numbers = sc.nextInt();
    }

    for (int i = 1; i <= numbers; i++) {
        for (int j = 1; j<=numbers; j++) {
            System.out.print(i*j + "\t");
        }
        System.out.println();
    }
}