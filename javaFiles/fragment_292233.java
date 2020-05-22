public class MyClass {
    public static void main(String args[]) {
        String sentence = "I have 20 apples.\n" +
                   "My friend has 15 apples.\n" +
                   "My cousin has nothing.";

        System.out.println(incrementCharacters(sentence));           

    }

    public static String incrementCharacters(String sentence) {
        StringBuilder sb = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            sb.append(Character.isLetter(c) ? (char)(c + 2) : (char)c);
        }

        return sb.toString();
    }
}