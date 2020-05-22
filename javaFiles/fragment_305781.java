public class AuthToken extends Auth {

    Token token;

    public AuthToken(String token) {
        this.token = new Token(token);
    }

    static class Token {
        String token;

        public Token(String token) {
            this.token = token;
        }

    }
}