public static class Validate 
{
    public static void IsTrue(bool value) 
    {
        if (!value) throw new InvalidOperationException(message)
    }
}