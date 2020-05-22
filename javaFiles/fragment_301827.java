// -------------------
// Perform Luhn check
// -------------------

public static boolean isCreditCardValid(String cardNumber) {
    String digitsOnly = getDigitsOnly(cardNumber);
    int sum = 0;
    int digit = 0;
    int addend = 0;
    boolean timesTwo = false;

    for (int i = digitsOnly.length() - 1; i >= 0; i--) {
        digit = Integer.parseInt(digitsOnly.substring(i, i + 1));
        if (timesTwo) {
            addend = digit * 2;
            if (addend > 9) {
                addend -= 9;
            }
        } else {
            addend = digit;
        }
        sum += addend;
        timesTwo = !timesTwo;
    }

    int modulus = sum % 10;
    return modulus == 0;

}