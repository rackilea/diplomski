public class Main{
    Data d;
    public static void main(String s[]) throws InterruptedException{
        Main m = new Main();
        Prod p = new Prod(m);
        Cons c = new Cons(m);
        new Thread(p).start();
        new Thread(c).start();

    }