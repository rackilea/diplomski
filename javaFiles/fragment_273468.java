public class Bubbled {
    public static void main(String[] args) {
        char bubbledA = 'ⓐ';
        int lowerCaseOffset = bubbledA - 'a';
        int upperCaseOffset = bubbledA - 'A';

        String input = "Hello";
        StringBuilder bubbledOutput = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                bubbledOutput.append((char)(c + upperCaseOffset));
            } else {
                bubbledOutput.append((char)(c + lowerCaseOffset));
            }
        }

        System.out.println(bubbledOutput.toString());
    }
}