public class Token
{
    public static enum TokenType
    {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        NUMBER,
        IDENTIFIER,
        OPEN_PARENTHESIS,
        CLOSE_PARENTHESIS,
        OPEN_BRACKET,
        CLOSE_BRACKET,
        EOL // End of line
    }

    public Token( TokenType type, String value)
    {
        this.type = type;
        this.value = value;
    }

    private TokenType type;
    public String value;

    public TokenType getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return value;
    }
}