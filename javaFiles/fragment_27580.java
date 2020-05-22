import static Casts.cast;

public class Test
{
    public static void main(String[] args)
    {
        final Integer integer = new Integer(5);

        // This one compiles fine.
        final Number number = Casts.<Integer, Number>cast(integer);

        // This one fails compilation:
        // PS> javac Test.java
        // Test.java:11: illegal start of expression
        //             final Number number = <Integer, Number>cast(integer);
        //                                                    ^
        // Test.java:11: not a statement
        //             final Number number = <Integer, Number>cast(integer);
        //                                                        ^
        final String string = <Integer, String>cast(integer);
    }
}