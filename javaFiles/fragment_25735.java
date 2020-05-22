import java.util.ArrayList;
import java.util.Random;

class DummyInteger {
    private int i;
    public DummyInteger(int i) {
        this.i = i;
    }
    public int getI() {
        return i;
    }
}

public class ObjectCreationTest {

    final static int ITERATIONS = 2000000;
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());

        int[] randArr = new int[ITERATIONS];
        for(int i = 0; i < ITERATIONS; i++) {
            randArr[i] = r.nextInt();
        }
        DummyInteger[] iArr = new DummyInteger[ITERATIONS];
        long start = System.currentTimeMillis();
        for(int i = 0; i < ITERATIONS; i++) {
            ArrayList<DummyInteger> list = new ArrayList<DummyInteger>(); 
            list.add(new DummyInteger(randArr[i]));
            iArr[i] = list.get(0);
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Creating %d objects took %d ms",ITERATIONS*2,end-start));
        int sum = 0;
        for(DummyInteger mi: iArr) {
            sum += mi.getI();
        }
        System.out.println(sum);
        }
}