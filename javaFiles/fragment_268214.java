public abstract class Heap {
    private Integer[] values;

    public int compare(int i , int j)
    {
        throw new RuntimeException("Not implemented");
    }

    public void SomeHeapMethod()
    {
        if(this.compare(values[0], values[1]) > 0)
            return;
    }
}

class MinHeap extends Heap
{
    public int compare(int i , int j)
    {
        return i + j % 2;
    }
}

class MaxHeap extends Heap
{
    public int compare(int i , int j)
    {
        return i + j % 1;
    }
}