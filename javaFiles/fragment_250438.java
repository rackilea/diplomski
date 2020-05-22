public class Main {
    public static void main(String[] args) {
        recur(0, "Hello how are you", 0);
    }

    private static void recur(int index, String text, int count) {
        if (text.length() >= 1) {
            char currentCharacter = text.charAt(0);

            if (index< text.length()) {
                if (currentCharacter == text.charAt(index)) {
                    count += 1;
                }

                recur(++index, text, count);
            } else {
                System.out.println(currentCharacter + ":" + count);
                text = text.replace(Character.toString(currentCharacter), "");

                recur(0, text, 0);
            }
        }
    }
}