public class Foo 
{
    // constants must always be immutable (no changeable state)
    public static final String EXTERNAL_CONSTANT;
    private static final String INTERNAL_CONSTANT;

    public static final int EXTERNAL_CONSTANT_USED_IN_SWITCH = 1;
    private static final int INTERNAL_CONSTANT_USED_IN_SWITCH = 2; 

     // no public variables that can be modified
     private static int internalClassVariable;

     static
     {
         EXTERNAL_CONSTANT = "Hello";
         INTERNAL_CONSTANT = "World";
     }

     private final List<String> constantsMustBeStaticAndFinal;
     private int instanceVariable;

     {
         constantsMustBeStaticAndFinal = new ArrayList<String>();
     }

     public Foo(final int parametersAreAlwaysFinal)
     {
         final int localVariable;

         locatlVariable   = parameterAreALwaysFinal * 10;
         instanceVariable = localVariable;
     } 
}