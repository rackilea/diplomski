public class  Fibonacci {
    private int n;
    private int fib1;
    private int fib2;
    private int fib3;

    public Fibonacci(int ny){
        n=ny;
        fib1=1;
        fib2=1;
        fib3=0;
    }
    public int nextNumber() {
        while(n-->2) {
            fib3=fib1+fib2;
            fib1=fib2;
            fib2=fib3;
        }
        return fib3;
    }
    public int getFib1() {
        return fib1;
    }
    public int getFib2() {
        return fib2;
    }
}
public class FibonacciGenerator{
    public static void main(String[] args) {
        Scanner sd = new Scanner(System.in);
        System.out.println("Enter the amount of fibonaccis you want: ");
        int ny = sd.nextInt();
        Fibonacci num = new Fibonacci(ny);

        System.out.println(num.getFib1());
        System.out.println(num.getFib2());

        for(int i = 3; i < ny; i++){
            num  = new Fibonacci(i);
            System.out.println(num.nextNumber());
        }
    }
}