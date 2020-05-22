public static int promptUser(Scanner in, String prompt, int min, int max) {
    int userTempVal = 0;

    do {
        if (in.hasNextInt()) {
            userTempVal = in.nextInt();
            if (userTempVal < min || userTempVal > max) {
                System.out.println(prompt);
            }
        } else {
            System.out.println("Invalid input");
            in.next();
        }

    } while (userTempVal < min || userTempVal > max);

    return userTempVal;
}