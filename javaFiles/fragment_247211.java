import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {

        List<List<Integer>> numlist = new ArrayList<List<Integer>>();

        List<Integer> somelist = new ArrayList<Integer>();
        somelist.add(5);
        somelist.add(6);
        Integer[] aa = new Integer[somelist.size()];
        Arrays.sort(somelist.toArray(aa), Collections.reverseOrder());
        somelist.clear();

        for(int i  =0;i<aa.length;i++)
        {
            somelist.add(aa[i]);
        }
        numlist.add(somelist);

        List<Integer> somelist2 = new ArrayList<Integer>();
        somelist2.add(7);
        somelist2.add(8);
        aa = new Integer[somelist2.size()];
        Arrays.sort(somelist2.toArray(aa), Collections.reverseOrder());
        somelist2.clear();

        for(int i  =0;i<aa.length;i++)
        {
            somelist2.add(aa[i]);
        }


        numlist.add(somelist2);

        // created [[6, 5], [8, 7]]
        System.out.println(numlist);

    }
}