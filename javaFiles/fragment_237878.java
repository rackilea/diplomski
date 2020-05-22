public class Bob
{
    // member variables
    private int value;

    // simple constructor
    private Bob()
    {
        value(0);
    }

    // constructor with value
    private Bob(int value)
    {
        value(value);
    }

    // get value
    public final int value()
    {
        return this.value;
    }

    // set value
    private final void value(int value)
    {
        this.value = value;
    }


    // mutable class modifies base class
    public static class Mutable extends Bob
    {
        // simple constructor
        private Mutable()
        {
            super();
        }

        // constructor with value
        private Mutable(int value)
        {
            super(value);
        }

        // set value
        public final void value(int value)
        {
            super.value(value);
        }
    }


    // factory creator for immutable
    public static final Bob immutable(int value)
    {
        return new Bob(value);
    }

    // factory creator for mutable
    public static final Mutable mutable()
    {
        return new Mutable();
    }

    // another mutable factory creator
    public static final Mutable mutable(int value)
    {
        return new Mutable(value);
    }
}