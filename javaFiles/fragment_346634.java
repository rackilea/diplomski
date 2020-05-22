public class PasswordRandomizer {
    private Random random = new Random();
    private int length;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public PasswordRandomizer(int length) {
        // Initialize the variable
        this.length = length;
    }

    public String createPassword() {
        int localLength = this.length;
        String password = "";
        while ( localLength > 0 ) {           
            int num = this.random.nextInt(26);
            char character = alphabet.charAt(num);
            password += character;
            localLength--;
        }
        return password;
    }
}