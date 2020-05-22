public void method( int id ) throws FooException
{
    try
    {
        someMethodThatThrows();
    }
    catch ( ArrayIndexOutOfBoundsException e )
    {
        throw new FooException( id, e );
    }
}

private void someMethodThatThrows()
{
    throw new ArrayIndexOutOfBoundsException();
}