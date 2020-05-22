import it.unimi.dsi.fastutil.BigArrays;
import it.unimi.dsi.fastutil.BigList;
import it.unimi.dsi.fastutil.BigSwapper;
import it.unimi.dsi.fastutil.longs.LongComparator;
import it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList;

public class App 
{
    public static void main( String[] args )
    {
        BigList<String> bigList = new ObjectBigArrayBigList<String>();
        bigList.add("Z");
        bigList.add("X");
        bigList.add("Y");
        bigList.add("A");
        bigList.add("C");
        bigList.add("B");

        System.out.println("Biglist before: " + bigList.toString());

        LongComparator cmp = (i,j) -> bigList.get(i).compareTo(bigList.get(j));
        BigSwapper swapper = (i,j) -> {
            String tmp = bigList.get(i);
            bigList.set(i, bigList.get(j));
            bigList.set(j, tmp);
        };

        BigArrays.mergeSort(0, bigList.size64(), cmp, swapper);

        System.out.println("Biglist after : " + bigList.toString());
     }
}