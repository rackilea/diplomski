public class Main {

    /**
     * Hepler method to convert codepoints ('digitCodePoints') into their decimal corresponding
     * number (to be used with {@link #horner(java.lang.String, java.lang.String) horner method})
     * depending on the alphabet ('alphabetCodePoints').
     * @param digitCodePoints the raw digits of the number (most significant digit first).
     * @param alphabetCodePoints the raw alphabet codepoints of the system (least significant codepoint first). For example "01" for binary.
     * @return 
     */
    private static int[] toDigits(final int[] digitCodePoints,
                                  final int[] alphabetCodePoints) {
        final int[] result = new int[digitCodePoints.length];
        for (int d = 0; d < digitCodePoints.length; ++d) {

            //Find where is the digitCodePoints[d] located in alphabetCodePoints:
            int index = 0;
            while (digitCodePoints[d] != alphabetCodePoints[index]) //Will throw ArrayIndexOutOfBoundsException if the digitCodePoints[d] is not found in alphabetCodePoints.
                ++index;

            result[d] = index;
        }
        return result;
    }

    /**
     * Works on codepoints.
     * @param digits the codepoints' literal which stores the digits of the number.
     * @param alphabet the alphabet of the system for which the convertion will take place. For example "01" for binary. Least significant digit comes first.
     * @return the decimal value of the resulting number.
     */
    public static int horner(final String digits,
                             final String alphabet) {
        final int[] alphabetCPs = alphabet.codePoints().toArray();
        return horner(toDigits(digits.codePoints().toArray(), alphabetCPs), alphabetCPs.length);
    }

    public static int horner(final int[] digits,
                             final int system) {
        return horner(digits, 0, digits.length, system);
    }

    /**
     * Standard method for converting 'digits' to their decimal number by Horner's method.
     * @param digits the digits of each place (most significant digit first).
     * @param offset the offset of 'digits' where we should end recursing.
     * @param length the length of 'digits' starting at 'offset'.
     * @param system the system for the convertion. For example 2 for binary, 16 for hexadecimal, and so on.
     * @return the decimal value of the resulting number.
     */
    public static int horner(final int[] digits,
                             final int offset,
                             final int length,
                             final int system) {
        return horner(digits, offset, offset + length - 1, 1, system);
    }

    /**
     * Main recursive method.
     * @param digits the digits of each place (most significant digit first).
     * @param offset the offset of 'digits' where we should end recursing.
     * @param index the index in digits to calculate next.
     * @param step how 'fast' we are traversing the array 'digits'. Typically 1. This exists mainly to create a different method signature than {@link #horner(int[], int, int, int) this} method.
     * @param system the system for the convertion. For example 2 for binary, 16 for hexadecimal, and so on.
     * @return the decimal value of the resulting number.
     */
    private static int horner(final int[] digits,
                              final int offset,
                              final int index,
                              final int step,
                              final int system) {
        if (digits[index] >= system)
            throw new IllegalArgumentException("digits[" + index + "]==" + digits[index] + " does not belong to the system " + system + '.');
        return index - step < offset
               ? digits[index]
               : horner(digits, offset, /* here you can see the usage of 'step': */ index - step, step, system) * system + digits[index];
    }

    public static void main(final String[] args) {
        System.out.println(horner(   new int[]{1, 0, 1, 1}   ,    2   )); //11.
        System.out.println(horner(   new int[]{0xF, 0xF}     ,    16  )); //255.
        System.out.println(horner( /* the number: */ "ffff" , /* the alphabet: */ "0123456789abcdef" )); //65535.
    }
}