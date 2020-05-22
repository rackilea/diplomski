/** Do a thing. myInt must be positive */
void someMethod(Integer myInt)
{
    if (myInt < 0)
    {
        throw new IllegalArgumentException("Can't be negative");
    }
    // do something
}

void myCaller()
{
    someMethod( 1); // won't throw
    someMethod(-1); // will throw
}