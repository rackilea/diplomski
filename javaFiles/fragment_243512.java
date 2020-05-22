class PasswordGenerator {
    final Random rand = new Random();
    final static String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String uppercaseLetters(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(upperCase.charAt(rand.nextInt(upperCase.length())));
        }
        return sb.toString();
    }
}