public class A
{
    private boolean field = false;

    public void foo()
    {
        Runnable r = new Runnable()
        {
            private boolean field = true;

            @Override
            public void run()
            {
                System.out.println(field); // prints true
                System.out.println(this.field); // prints true
                System.out.println(A.this.field); // prints false
            }
        };
    }
}