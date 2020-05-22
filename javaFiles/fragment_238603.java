@SuppressWarnings("unchecked")
public enum CharToken implements Token { // Note: No type parameter specified!

    OPEN('('),
    CLOSE(')'),
    SEPARATOR(','),
    EOL(';');

    public static <T> Token<T> open(){ return OPEN; }
    public static <T> Token<T> close(){ return CLOSE; }
    public static <T> Token<T> separator(){ return SEPARATOR; }
    public static <T> Token<T> eol(){ return EOL; }

    private final char ch;

    private CharToken(char ch) {
       this.ch = ch;
    }
} 

// Usage:
Token<BigDecimal> bdOpen = CharToken.open();
Token<Integer> intOpen = CharToken.open();