import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomArrayComparator<T extends Comparable<T>, E> implements Comparator<T>
{
    private T[] mainArray;
    private Map<E, Integer> indexesMap;

    public CustomArrayComparator(T[] mainArray, E[] associatedArray)
    {
        this.mainArray = mainArray;
        indexesMap = new HashMap<E, Integer>();
        for(int i = 0; i < mainArray.length; i++)
        {
            indexesMap.put(associatedArray[i], i);
        }
    }

    @Override
    public int compare(T t1, T t2)
    {   
        return mainArray[indexesMap.get(t2)].compareTo(mainArray[indexesMap.get(t1)]);
    }
}