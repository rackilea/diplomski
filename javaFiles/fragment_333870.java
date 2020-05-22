import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3);
        ArrayList<Integer> val = new ArrayList<Integer>(list);
        System.out.println(val.size());
    }
}