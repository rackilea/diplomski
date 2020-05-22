import java.util.Random;

public class PP425 {
    public static String generatePalindrome (int size) {
        Random rand = new Random();
        StringBuilder random = new StringBuilder(size);
        for (int i = 0; i < (int)Math.ceil((double)size/2); i++) {
            char ch = (char)(rand.nextInt(26) + 97);
            random.append(ch);
        }
        for(int i = size/2-1; i >= 0; i--)
            random.append(random.charAt(i));

        return random.toString();
    }
    public static void main(String[] args) {
        System.out.println(generatePalindrome(3));
    }
}