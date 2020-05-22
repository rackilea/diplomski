public class ValidatingPassword {

    public static void main(String[] args) {
        String[] passwords = { "testcase", "T3stCas3%45" };
        for (String password : passwords) {
            System.out.println(password + " : " + isSecurePassword(password));
        }
    }

    /**
     * Is this a secure password?
     * At least 10 characters, at least one capital letter, one small
     * letter and one digit.
     * 
     * @param password never null.
     * @return whether password is secure.
     */
    public static boolean isSecurePassword(String password) {

        int lengthPassword = password.length();
        if (lengthPassword < 10) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasSmallLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < lengthPassword; i++) {
            char ch = password.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                hasCapital = true;
            }
            if ('a' <= ch && ch <= 'z') {
                hasSmallLetter = true;
            }
            if ('0' <= ch && ch <= '9') {
                hasDigit = true;
            }
        }
        return hasCapital && hasSmallLetter && hasDigit;
    }
}