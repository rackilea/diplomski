public class Token {
    private TokenType type;
    private Object value;
    public Token(TokenType type) { 
        this.type = type; 
        this.value = null;
    }
    public Token(TokenType type, Object value) { 
        this.type = type;
        this.value = value;
    }
    // getters and setters for type and value omitted below
    // ...
}