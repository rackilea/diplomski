private static void recur(int startingIndex, int recursionIndex, String text, int count) {
    if (text.length() >= 1) {
        if (startingIndex < text.length()) {

            char currentCharacter = text.charAt(startingIndex);

            if (recursionIndex < text.length()) {
                if (currentCharacter == text.charAt(recursionIndex)) {
                    count += 1;
                }

                recur(startingIndex, ++recursionIndex, text, count);
            } else {
                System.out.println(currentCharacter + ":" + count);
                text = text.replace(Character.toString(currentCharacter), "");

                recur(0, 0, text, 0);
            }
        }
    }
}