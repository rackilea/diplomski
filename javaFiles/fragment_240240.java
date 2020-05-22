public class Fib extends Thread
{
    private int x;
    public int answer;

    public Fib(int x) {
        this.x = x;
    }

    public void run() {
        if( x <= 2 )
            answer = 1;
        else {
            try {
                Fib f1 = new Fib(x-1);
                Fib f2 = new Fib(x-2);
                f1.start();
                f2.start();
                f1.join();
                f2.join();
                answer = f1.answer + f2.answer;
            }
            catch(InterruptedException ex) { }
        }
    }

    public static void main(String[] args)
        throws Exception
    {
        try {
            Fib f = new Fib( Integer.parseInt(args[0]) );
            f.start();
            f.join();
            System.out.println(f.answer);
        }
        catch(Exception e) {
            System.out.println("usage: java Fib NUMBER");
        }
    }
}