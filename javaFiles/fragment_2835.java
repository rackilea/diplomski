//an array which has a gap in between and
//elements can be removed from either end of the gap.
private static final class GapArray
{
    private final int[] array;
    private int gapStart;
    private int gapLength;

    private GapArray(int[] array)
    {
        this.array = array;
        this.gapStart = array.length;
    }

    int get(int index)
    {
        checkBounds(index);
        if (index < gapStart)
        {
            return array[index];
        }
        else
        {
            return array[index + gapLength];
        }
    }

    private void checkBounds(int index)
    {
        if (index < 0 || index >= size())
        {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }
    //index is either just before start of the gap or just after end of gap.
    int remove(int index)
    {
        checkBounds(index);
        if (gapLength == 0)
        {
            gapStart = index;
            gapLength++;
            return array[gapStart];
        }
        else
        {
            if (index == gapStart - 1)
            {
                gapStart--;
                gapLength++;
                return array[gapStart];
            }
            else if (index == gapStart)
            {
                int value = array[gapStart + gapLength];
                gapLength++;
                return value;
            }
            else
            {
                throw new IllegalArgumentException("elements can be removed either end of the gap only");
            }
        }
    }

    int size()
    {
        return array.length - gapLength;
    }
}