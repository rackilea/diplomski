import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomArrayComparator implements Comparator<String>
{
    private String[] pointsArray;
    private Map<String, Integer> idsMap;

    public CustomArrayComparator(String[] pointsArray, String[] countriesArray)
    {
        this.pointsArray = pointsArray;
        idsMap = new HashMap<String, Integer>();
        for(int i = 0; i < pointsArray.length; i++) idsMap.put(countriesArray[i], i);
    }

    @Override
    public int compare(String s1, String s2)
    {   
        return pointsArray[idsMap.get(s2)].compareTo(pointsArray[idsMap.get(s1)]);
    }
}