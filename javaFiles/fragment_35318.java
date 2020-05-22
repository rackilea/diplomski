public static int getInteger2(String message) {
    int count = -1;

    boolean isValidInteger = false;

    do {
        System.out.println(message);

        if (console.hasNextInt()) {
            count = console.nextInt();

            if (count != 0) {
                isValidInteger = true;
            } else {
                System.out.println("Denominator cannot equal zero.");
            }
        } else {
            console.next();
        }
    } while (!isValidInteger);

    return count;
}