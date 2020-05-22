private static long mStartedTime;

public static void main(String args[])
{
    long TotalTime = 0;
    int NumberOfLoops = 7;

    for(int i = 0; i < NumberOfLoops; i++)
    {
        mStartedTime = System.currentTimeMillis();

        for(float Index = 0; Index < 10000000; Index++)
        {
            test1("wewgwgwegwegwegsd veweewfefw fwefwef wfwefdwvdw wefwe wevwev etbe tbebetbetb evberve");
        }

        System.out.println("Program took: " + String.valueOf(System.currentTimeMillis() - mStartedTime) + " to complete.");
        TotalTime += System.currentTimeMillis() - mStartedTime;
    }

    System.out.println("Average time taken: " + String.valueOf(TotalTime / NumberOfLoops));
}


public static void test1(String THisIsText)
{
    String Test = THisIsText;
    Test = Test.substring(1);
}

private static String mTempString;
public static void test2(String THisIsText)
{
    mTempString = THisIsText;
    mTempString = mTempString.substring(1);
}