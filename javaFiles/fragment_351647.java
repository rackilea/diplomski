static boolean areAssertionsEnabled()
{
    //noinspection UnusedAssignment
    boolean b = false;
    //noinspection ConstantConditions,AssertWithSideEffects
    assert b = true;
    //noinspection ConstantConditions
    return b;
}