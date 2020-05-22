import java.util.*;
public class Test extends TimerTask {

    private static Timer timer = new Timer();

    public static void main(String[] args) {
        Test t = new Test();
        timer.schedule(new Test(), 1, 50); 
    }
    public void run() {         

        timer.schedule(new Test(), 1000, 1000);
        System.out.println(System.currentTimeMillis()/1000);
    }

}