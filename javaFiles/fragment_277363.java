import java.util.ArrayList;
import java.util.List;

public class Operations {

    public static Collection<Integer> add(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < l1.size(); i++) {
            result.add(l1.get(i) + l2.get(i));
        }
        return result;
    }
}