private static char[] subtractValue(char[] greater, char[] smaller) {
        char[] result = new char[greater.length];
        int index = 1;
        int carry = 0;
        int digit;

        // 1. subtract shorter part
        while (index <= smaller.length) {
                digit = Character.getNumericValue(greater[greater.length-index]) - Character.getNumericValue(smaller[smaller.length-index]) - carry;
                carry = digit < 0 ? 1 : 0;
                digit = digit + (carry == 1? 10 : 0);
                result[greater.length - index] = Character.forDigit(digit, 10);
                index++;
        }

        // 2. carry rippling
        while (index <= greater.length) {
                digit = Character.getNumericValue(greater[greater.length-index]) - carry;
                carry = digit < 0 ? 1 : 0;
                digit = digit + (carry == 1 ? 10 : 0);
                result[greater.length - index] = Character.forDigit(digit, 10);
                index++;
        }

        // 3. trim out trailing zeros
        int i;
        for(i = 0; i < result.length - 1 && result[i] == '0'; i++) {
        }
        return Arrays.copyOfRange(result, i, result.length);
}