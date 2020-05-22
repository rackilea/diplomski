public class DynamicArrayOfInt
{
private int[] data;
public DynamicArrayOfInt()
{
    data = new int[1];
}
public int get(int position)
{
    if (position >= data.length)
        return 0;
    else 
        return data[position];
    }
public void put(int position, int value)
{
    if (position >= data.length)
    {
        int newSize = 2 * data.length;
        if (position >= newSize)
            newSize = 2 * position;
        int[] newData = new int[newSize];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
        System.out.println("Size of dynamic array increased to " + newSize);
    }
    data[position] = value;
}
}