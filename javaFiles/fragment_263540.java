import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class IntCount {

    int [] a = new int [] {2,3,3,4,5,6,9,2,7,3,3};

    public IntCount()
    {
        Set<Integer> b = new HashSet<Integer>();
        for (int i : a)
        {
            if (containsTwice(i))
                b.add(i);
        }
        System.out.println(Arrays.toString(b.toArray()));
    }

    boolean containsTwice(int i)
    {
        int count = 0;
        for (int j : a)
        {
            if (j == i)
                count++;
        }
        return (count > 1);
    }

    public static void main(String [] args)
    {
        new IntCount();
    }
}