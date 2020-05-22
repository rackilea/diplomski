import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<PasswordWithScore> passwords = new ArrayList<>();

        int numberOfPasswords = 5;
        int lengthOfPassword = 5;

        Random rand = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < numberOfPasswords; i++) {
            StringBuilder password = new StringBuilder();
            for (int j = 0; j < lengthOfPassword; j++) {
                password.append(chars.charAt(rand.nextInt(chars.length())));
            }
            passwords.add(new PasswordWithScore(password.toString()));
        }

        passwords.sort(Comparator.comparing(PasswordWithScore::getScore).reversed());
        System.out.println(passwords);
    }
}