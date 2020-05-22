import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class StackOverflow {

    public static void main(String[] args) {
        AtomicInteger integer=new AtomicInteger(0);
        AtomicBoolean flag=new AtomicBoolean(true);
        Sequence sequence1=new Sequence(integer, flag);
        Sequence sequence2=new Sequence(integer, flag);
        sequence1.start();
        sequence2.start();
    }
}