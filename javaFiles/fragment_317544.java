private static void ExecuteNTimes(int n, Action method)
{
    for (int i = 0; i < n; i++)
    {
        method();
    }
}