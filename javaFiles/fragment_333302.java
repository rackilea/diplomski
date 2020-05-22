import java.util.concurrent.TimeUnit ;

public class Anything { 
    public static void main( String[] args ) throws InterruptedException {
        System.out.println("hi");
        TimeUnit.SECONDS.sleep(6);
        System.out.println("hi");
    }
}