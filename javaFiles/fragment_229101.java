public class SharedClass
{
    private static SharedClass sharedClass;

    // global variables
    public double latInfo, LonInfo;

    public static SharedClass getInstance()
    {
        if (sharedClass == null)
            sharedClass = new SharedClass();

        return sharedClass;
    }

    private SharedClass()
    {
    }
}