package u8a1;

import java.util.List;
import java.util.ArrayList;

public class BinarySearch<Key extends Comparable<Key>, Value> implements IBinarySearch<Key, Value>, IMeasure {

    private int dividedBy = 2;

    private int numOfCall = 1;

    public Key key;

    public Value value;

    public BinarySearch() {
        this.key = key;
        this.value = value;
    }
    public Value find(List<Unit<Key, Value>> haystack, Key needle)
    {
        if (haystack.size() == 0) return null;
        if (needle.compareTo(haystack.get(haystack.size()/dividedBy).key) == 0) return haystack.get(haystack.size()/dividedBy).value;
        if (haystack.size() == 1) return null;
        else if(needle.compareTo(haystack.get(haystack.size()/dividedBy).key) > 0)
        {
            ++numOfCall;
            return find(haystack.subList((haystack.size()/dividedBy), haystack.size()), needle);
        }
        else if(needle.compareTo(haystack.get(haystack.size()/dividedBy).key) < 0)
        {
            ++numOfCall;
            return find(haystack.subList(0, (haystack.size()/dividedBy)), needle);
        }
        else return null;
    }
    public void setFactor(int factor)
    {
        dividedBy = factor;
    }
    public int getNumberofCalls()
    {
        return numOfCall;
    }
}