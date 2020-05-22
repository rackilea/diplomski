import java.util.ArrayList;
import java.util.Random;

public class Cup {

    ArrayList<Integer> c = new ArrayList<Integer>();
    private Random r;

    public Cup() {
        c.add(1);
        c.add(2);
        c.add(3);

        //here you should use your r attribute
        r = new Random();
    }

    public int count() {
        return c.size();
    }

    public int select() {
        int index = r.nextInt(c.size());
        return c.get(index);
    }

    public void remove(int m) {
        c.remove(m);
    }
}