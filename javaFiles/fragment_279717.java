public class ExceptionsStatic    {

public static void main(String... args)
{
    withNormal();
    withTry();
}

static int fooVar;
static void foo()
{
    fooVar++;
}

static int foo2Var;
static void foo2() throws Exception
{
    foo2Var++;
}

static void withTry()
{
    long t1 = System.currentTimeMillis();

    foo2Var = 0;
    for(int i = 0; i < 100000000; i++)
    {
        try
        {
            foo2();
        }
        catch(Exception e)
        {

        }
    }

    long t2 = System.currentTimeMillis();

    System.out.println("try time taken " + (t2 - t1) + "; " + foo2Var);
}

static void withNormal()
{
    long t1 = System.currentTimeMillis();

    fooVar = 0;
    for(int i = 0; i < 100000000; i++)
    {
        foo();
    }

    long t2 = System.currentTimeMillis();

    System.out.println("normal time taken " + (t2 - t1) + "; " + fooVar);
}