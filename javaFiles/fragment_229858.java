import org.openjdk.jol.info.GraphLayout;

import org.openjdk.jol.util.VMSupport;
import java.util.*;

public class JOLTest {
    public static void main(String[] args) throws Exception {
        List<Long> list = new LinkedList<>();
        for (long i = 0; i < 4000L; i++) {
            list.add(i);
            if((i+1) % 1000 == 0) {
                System.out.println("i = "+(i+1));
                System.out.println(GraphLayout.parseInstance(list).toFootprint());
            }
        }
    }
}