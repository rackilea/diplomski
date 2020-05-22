public static void main(String[] args) {
    for(String s : generate(3, 0, 4)) {
        System.out.println(s);
    }
}

private static List<String> generate(int n, int a, int b) {
    List<String> numbers = new ArrayList<>();
    int base = b - a + 1;                        // (1)
    for(int i = 0; i < Math.pow(base, n); i++) { // (2)
        String s = Integer.toString(i, base);    // (3)
        s = substituteSymbols(s, a);             // (4)
        s = String.format("%" + n + "s", s);     // (5)...
        s = replacePadding(a, s);                // ...(5)

        numbers.add(s);
    }
    return numbers;
}

private static String substituteSymbols(String s, int a) {
    char[] digits = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int c = 0; c < digits.length; c++) {
        int val = Character.getNumericValue(digits[c]) + a;
        sb.append(Character.forDigit(val, Character.MAX_RADIX));
    }
    return sb.toString();
}

private static String replacePadding(int a, String s) {
    return s.replace(' ', Character.forDigit(a, Character.MAX_RADIX));
}