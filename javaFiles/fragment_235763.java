public class FooException extends Exception
{

    public FooException( int id, Throwable cause )
    {
        super( "user " + id + " not found", cause );

    }

}