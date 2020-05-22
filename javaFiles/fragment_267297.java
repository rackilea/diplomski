public static int lastDigitsSum(int total) {
    try (Scanner scan = new Scanner(System.in)) {
        String str = scan.next();
        int count = 0;

        for (int i = str.length() - 1, j = 0; i >= 0 && j < total; i--, j++) {
            if (Character.isDigit(str.charAt(i)))
                count += str.charAt(i) - '0';
            else
                throw new RuntimeException("Input is not a number: " + str);
        }

        return count;
    }
}