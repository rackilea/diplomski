public static void main(final String[] arguments)
{
    Object[] myArray = new Object[arguments.length];

    for (int index = 0; index < arguments.length; ++index)
    {
        myArray = transformAsDesired(arguments[index]);
    }
}