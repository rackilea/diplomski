public static boolean containsDigit(int n, int digit) {
    return String.valueOf(n).contains(String.valueOf(digit));
}

...

int n = 333333;
boolean nContains3And7 = containsDigit(n, 3) && containsDigit(n, 7);