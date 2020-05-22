public static void main(String[] args) {
    int low = 0;
    int high = 0;
    for (String s : args) {
        try {
            int i = Integer.parseInt(s);
            if (i > 50) high++;
            else low++;
        } catch (NumberFormatException e) {
            System.err.printf("%s is not a number!\n", s);
        }
    }
    System.out.printf("%d numbers are less than or equal to 50.\n", low);
    System.out.printf("%d numbers are higher than 50.\n", high);
}