class FinalField
{
    final int x;
    int y;

    public FinalField()
    {
        Thread t = new Thread(new TestThread(this));
        t.start();

        y = 4;
        x = 3;
    }
}

class TestThread implements Runnable
{
    FinalField f;
    TestThread(FinalField f)
    {
        if(f.x != 3)
            System.out.println("value of x = " + f.x);

        this.f = f;
    }

    public void run() 
    {
        if(f.x != 3)
            System.out.println("value of x = " + f.x);
    }
}

public class Test
{
    public static void main(String[] args) 
    {
        for(int i=0; i<100; i++)
        {
            new FinalField();
        }
    }
}