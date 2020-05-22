public class LetterCounter {
    public static long countLetters(String value) {
        if (value == null) {
            return 0;
        }
        return value.chars().filter(Character::isLetter).count();
    }
}