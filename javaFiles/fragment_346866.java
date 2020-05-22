import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            final List<Scalar> scalars = new ArrayList<>();
            scalars.add( new Scalar( "a", 1 ) );
            scalars.add( new Scalar( "b", 2 ) );
            scalars.add( new Scalar( "d", 3 ) );
            scalars.add( new Scalar( "varx", 5  ) );

            ExpressionParser parser = new ExpressionParser();

            System.out.println( parser.compile("a - (b+A[B[2]])*d + 3", scalars));
            System.out.println( parser.compile("5*(2+varx)+a", scalars));
            System.out.println( parser.compile("B[a*384+(5+(5*(varx+3)))]+varx", scalars));
            System.out.println( parser.compile("34+", scalars ) );
        }
        catch (ExpressionException ex)
        {
            System.out.println( ex.getMessage() );
        }
    }
}