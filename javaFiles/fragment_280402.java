private static String toScienticNotation(double n) {

    String result = "";

    if (n < 1 && n > 0) {

        int counter = 0;
        double answer = n;

        while (answer < 1) {
            answer = answer * 10;
            counter--;
        }

        result = String.valueOf(answer) + " x 10 ^ "
                + String.valueOf(counter);
    }
    return result;
}