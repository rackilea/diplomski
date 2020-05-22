public class Main {
    static Window f;
    public int foo = 0;

    public static void main(String[] args){
        f = new Window();
        // do some other stuff
    }

    public static void incrementFooEverySecond(){
        while(true){
            foo++;
            f.repaintBar();
            Thread.sleep(1000);
        }
    }
}