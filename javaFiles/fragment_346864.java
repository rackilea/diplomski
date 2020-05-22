import expressionparser.Token.TokenType;
import java.util.List;

public class ExpressionParser
{
    private Tokenizer lex;
    private List<Scalar> scalars;

    public String compile( String expression, List<Scalar> scalars ) throws ExpressionException
    {
        lex = new Tokenizer(expression);
        this.scalars = scalars;
        return evalWholeExpression();
    }

    private String evalWholeExpression( ) throws ExpressionException
    {
        String result = evalExpression();
        lex.readAndComsumeToken(Token.TokenType.EOL);
        return result;
    }

    private String evalExpression() throws ExpressionException
    {
        String left = evalSummand();
        return evalTailSum( left );
    }

    private String evalSummand( ) throws ExpressionException
    {
        String left = evalFactor();
        return evalTailMultiplication( left );
    }

    private String evalFactor() throws ExpressionException
    {
        Token token = lex.readToken();
        if ( token.getType() == TokenType.OPEN_PARENTHESIS )
        {
            lex.consumeToken();
            String result = evalExpression();
            lex.readAndComsumeToken(TokenType.CLOSE_PARENTHESIS);
            return "(" + result + ")";
        }
        else if ( token.getType() == TokenType.NUMBER )
        {
            lex.consumeToken();
            return token.toString();
        }
        else if ( token.getType()==TokenType.IDENTIFIER )
        {
            lex.consumeToken();
            String tailArray = evalTailArray();
            if ( "".equals(tailArray) )
            {
                String scalarValue = evaluateScalar( token.toString() );
                return scalarValue;
            }
            else
            {
                verifyIsNotScalar( token.toString() );
                return token + tailArray;
            }
        }
        else
            throw new ExpressionException( "Incorrect expression" );
    }

    private String evalTailSum( String left ) throws ExpressionException
    {
        Token token = lex.readToken();
        if ( token.getType()==TokenType.PLUS )
        {
            lex.consumeToken();
            String right = evalSummand();
            return evalTailSum( left + "+" + right );
        }
        else if ( token.getType()==TokenType.MINUS )
        {
            lex.consumeToken();
            String right = evalSummand();
            return evalTailSum( left + "-" + right );
        }
        else
            return left;
    }

    private String evalTailMultiplication( String left ) throws ExpressionException
    {
        Token token = lex.readToken();
        if ( token.getType()==TokenType.MULTIPLY )
        {
            lex.consumeToken();
            String right = evalFactor();
            return evalTailSum( left + "*" + right );
        }
        else if ( token.getType()==TokenType.DIVIDE )
        {
            lex.consumeToken();
            String right = evalFactor();
            return evalTailSum( left + "/" + right );
        }
        else
            return left;
    }

    private String evalTailArray() throws ExpressionException
    {
        Token token = lex.readToken();
        if ( token.getType() == TokenType.OPEN_BRACKET )
        {
            lex.consumeToken();
            String result = evalExpression();
            lex.readAndComsumeToken(TokenType.CLOSE_BRACKET);
            return "[" + result + "]" + evalTailArray();
        }
        else
            return "";
    }

    private String evaluateScalar( String text ) throws ExpressionException
    {
        assert text!=null;
        for ( Scalar s : scalars )
        {
            if ( text.equals( s.identifier ) )
                return "" + s.value;
        }
        throw new ExpressionException( "Incorrect expression" );
    }

    private void verifyIsNotScalar( String text ) throws ExpressionException
    {
        assert text!=null;
        for ( Scalar s : scalars )
        {
            if ( text.equals( s.identifier ) )
                throw new ExpressionException( "Incorrect expression" );
        }
    }

}