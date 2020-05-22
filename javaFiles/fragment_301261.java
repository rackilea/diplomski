public class Example
{
    public static void main( String[] args )
    {
        String jh = System.getenv( "JOLIE_HOME" );
        String arg[] = {
            "-l",
            "./lib/*:$JOLIE_HOME/lib:$JOLIE_HOME/javaServices/*:$JOLIE_HOME/extensions/*".replaceAll("\\$JOLIE_HOME", jh),
            "-i",
            "$JOLIE_HOME/include".replaceAll("\\$JOLIE_HOME", jh),
            "main.ol"
        };
        try {
            final Interpreter interpreter = new Interpreter(arg, Example.class.getClassLoader(), null);
            Exception e = interpreter.start().get();
            if ( e != null )
                throw e;

            Value v = Value.create();
            v.setFirstChild( "number", 5 );
            CommMessage request = CommMessage.createRequest( "twice", "/", v );
            LocalCommChannel c = interpreter.commCore().getLocalCommChannel();
            c.send( request );
            CommMessage response = c.recvResponseFor( request ).get();
            if ( response.isFault() ) {
                System.out.println("thrown response.fault()");
                throw response.fault();
            }
            System.out.println( response.value().getFirstChild( "result" ).strValue() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}