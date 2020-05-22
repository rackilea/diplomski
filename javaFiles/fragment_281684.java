import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicatesInList
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(0,1,1,1,2,3,3,4,5,6,7,7,7,8);

        List<Integer> duplicates = computeDuplicates(list);

        // Prints [1, 1, 3, 7, 7]
        System.out.println(duplicates);

        // Prints [1, 3, 7]
        System.out.println(makeUnique(duplicates));
    }

    private static <T> List<T> makeUnique(List<? extends T> list)
    {
        return new ArrayList<T>(new LinkedHashSet<T>(list));
    }

    private static <T> List<T> computeDuplicates(List<? extends T> list)
    {
        Set<T> set = new HashSet<T>();
        List<T> duplicates = new ArrayList<T>();
        for (T element : list)
        {
            boolean wasNew = set.add(element);
            if (!wasNew)
            {
                duplicates.add(element);
            }
        }
        return duplicates;
    }
}