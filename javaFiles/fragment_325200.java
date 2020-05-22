public static void main(final String args[]) throws java.io.IOException {
    final String[] m = {"", "M", "MM"};
    final String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    final String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    final String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    try (final java.util.Scanner scanner = new java.util.Scanner(System.in)) {
        System.out.print("Enter a year to convert : ");
        final int year = scanner.nextInt();
        System.out.println(m[year / 1000] + c[(year / 100) % 10] + x[(year / 10) % 10] + i[year % 10]);
    }
}