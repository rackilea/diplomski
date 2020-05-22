import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import static java.lang.System.out;

public class Test {
    public static void main( String [] args ) {
        Timer timer = new Timer();
        timer.schedule( new TimerTask(){
            public void run() {
                out.println(new Date()+" No more bets, thank you!");
            }
        }, 10000 );
        out.println(new Date() + " Place your bets, place your bets!!");
    }
}