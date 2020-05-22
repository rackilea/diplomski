import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Is the sequence returned by i1 and i2 is the same?
        ListIterator<Integer> i1 = list.listIterator();
        ListIterator<Integer> i2 = list.listIterator();

        while (i1.hasNext())
        {
            System.out.println(i1.next());
        }
        while (i2.hasNext())
        {
            System.out.println(i2.next());
        }    
    }
}