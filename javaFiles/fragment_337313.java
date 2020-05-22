public class StringPadder {

    private static final String BETWEEN_NUMBER_AND_LETTER = "(?<=\\p{IsDigit})(?=\\p{IsAlphabetic})";
    private static final String BETWEEN_LETTER_AND_NUMBER = "(?<=\\p{IsAlphabetic})(?=\\p{IsDigit})";

    public static String addSpaces(String toPad) {
        return toPad.replaceAll(BETWEEN_NUMBER_AND_LETTER, " ").replaceAll(BETWEEN_LETTER_AND_NUMBER, " ");
    }

    public static void main(String[] args) {
        String toTest =  "سعید۰۱/۰۷/۱۳۹۵سعید";
        System.out.println(addSpaces(toTest));

    }
}