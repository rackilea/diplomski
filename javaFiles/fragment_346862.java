import java.util.regex.Matcher;
import java.util.regex.Pattern;
import expressionparser.Token.TokenType;

class Tokenizer
{
    private final String input;
    private Matcher matcher;
    private Token lastToken;

    public Tokenizer( String input )
    {
        this.input = input;
        Pattern pattern =
                Pattern.compile( "[+]|-|[*]|/|[0-9]+|[a-zA-Z]+|[(]|[)]|\\[|\\]|[ ]");
        matcher = pattern.matcher( input );
        lastToken = null;
    }

    public Token readAndComsumeToken( TokenType type ) throws ExpressionException
    {
        Token result = readToken();
        if ( result.getType()!=type )
            throw new ExpressionException("Erroneous exception" );
        lastToken = null;
        return result;
    }

    public Token readToken() throws ExpressionException
    {
        if (lastToken!=null)
            return lastToken;

        String value;
        // Read till a non blank is received
        do
        {
            if ( matcher==null )
            {
                lastToken = new Token(TokenType.EOL, "");
                return lastToken;
            }
            if ( !matcher.find() )
              throw new ExpressionException("Erroneous exception" );
            value = matcher.group();
            if ( matcher.end() >= input.length() )
            {
                // End of String
                matcher = null;
            }
            if ( value.length()==0 )
              throw new ExpressionException("Erroneous exception" );
        } while ( value.equals( " " ) ||
                 value.equals("\t") || value.equals("\n") ||
                 value.equals("\f") || value.equals("\r") );
        // Identify read token
        TokenType type;
        if ( value.equals("+") )
            type = TokenType.PLUS;
        else if ( value.equals("-") )
            type = TokenType.MINUS;
        else if ( value.equals("*") )
            type = TokenType.MULTIPLY;
        else if ( value.equals("/") )
            type = TokenType.DIVIDE;
        else if ( value.equals("(") )
            type = TokenType.OPEN_PARENTHESIS;
        else if ( value.equals(")") )
            type = TokenType.CLOSE_PARENTHESIS;
        else if ( value.equals("[") )
            type = TokenType.OPEN_BRACKET;
        else if ( value.equals("]") )
            type = TokenType.CLOSE_BRACKET;
        else
        {
            char firstChar = value.charAt(0);
            if ( firstChar>='0' && firstChar<='9' )
                type = TokenType.NUMBER;
            else
                type = TokenType.IDENTIFIER;
        }
        lastToken = new Token( type, value );
        return lastToken;
    }

    public void consumeToken() throws IllegalStateException
    {
        if ( lastToken==null )
            throw new IllegalStateException();
        lastToken = null;
    }
}