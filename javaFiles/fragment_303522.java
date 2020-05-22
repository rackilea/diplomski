import java.util.Arrays;

class IntTuple 
{
    static IntTuple of(int ... values)
    {
        return new IntTuple(values);
    }

    private final int data[];
    private IntTuple(int ... data)
    {
        this.data = data;
    }

    public int getDimensions()
    {
        return data.length;
    }

    public int get(int index)
    {
        return data[index];
    }
    @Override
    public String toString()
    {
        return Arrays.toString(data);
    }
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(data);
    }
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object == null)
        {
            return false;
        }
        if (!(object instanceof IntTuple))
        {
            return false;
        }
        IntTuple other = (IntTuple)object;
        return Arrays.equals(data, other.data);
    }
}