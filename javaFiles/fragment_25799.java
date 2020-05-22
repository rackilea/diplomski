class Program
{
    private static int instanceCount;

    public Program()
    {
        if (instanceCount > 5)
            throw new InvalidOperationException("Only 5 instances of Program are allowed");
        instanceCount++;
    }

    public static void main(String[] args)
    {
        for (int n = 0; n < 10; n++)
            new Program();
    }
}