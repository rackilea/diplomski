public class StackTraceDumper
{
    public static dumpAllStackTraces ()
    {
        for (Map.Entry <Thread, StackTraceElement []> entry: 
            Thread.getAllStackTraces().entrySet ())
        {
            System.out.println (entry.getKey ().getName () + ":");
            for (StackTraceElement element: entry.getValue ())
                System.out.println ("\t" + element);
        }
    }
}