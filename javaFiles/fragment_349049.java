while (true) {
    if (!in.hasNextInt()) {
        System.out.println("Input must be a number.");
        in.next();
    } else {
        int num = in.nextInt();

        if (num < 0 || num > 10) {
            System.out.println("Input must be between 1 and 10 (inclusive).");
        } else {
            // add num to collection
            break;
        }
    }
}