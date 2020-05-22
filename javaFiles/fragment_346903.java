public class FibonacciThread extends Thread {
    public volatile int result;
    int x;

    public FibonacciThread(int parameter) {
       x = parameter;
    }


    @Override
    public void run() {
        result = fib(x);
    }

    public int fib(int x) {
        if(x == 1) return 1;
        if(x == 2) return 1;
        return fib(x-1) + fib(x-2);
    }
}