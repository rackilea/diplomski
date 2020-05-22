import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ParallelSortSpeedTest
{
    public static void main(String[] args)
    {
        for (int size=100000; size<=1000000; size+=100000)
        {
            final String[] values1 = new String[size];
            final String[] values2 = new String[size];
            for (int i = 0; i < size; i++) {
                values1[i] = Integer.toString(i);
                values2[i] = values1[i];
            }
            Collections.shuffle(Arrays.asList(values1));
            Collections.shuffle(Arrays.asList(values2));
            final Comparator<String> comparator = (o1, o2) -> o2.compareTo(o1);

            testSort(values1, comparator);
            testParallelSort(values2, comparator);
        }
    }

    private static void testSort(
        String array[], final Comparator<String> comparator)
    {
        long startTimeInNano = System.nanoTime();
        Arrays.sort(array, comparator);
        long endTimeInNano = System.nanoTime();
        System.out.println("Arrays.sort        : totalTimeInMicro= " + 
            ((endTimeInNano - startTimeInNano)/1000)+", first "+array[0]);
    }

    private static void testParallelSort(
        String array[], final Comparator<String> comparator)
    {
        long startTimeInNano = System.nanoTime();
        Arrays.parallelSort(array, comparator);
        long endTimeInNano = System.nanoTime();
        System.out.println("Arrays.parallelSort: totalTimeInMicro= " + 
            ((endTimeInNano - startTimeInNano)/1000)+", first "+array[0]);
    }

}