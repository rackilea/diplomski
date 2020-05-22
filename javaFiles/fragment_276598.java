import java.util.Arrays;

public class Main
{
    public static void main(String atrgs[])
    {
        int[] array = {1,2,3,4,2,4,1,1,2,3,4,5,1,2,3,4,5,6,7,4,3,2,1};
        int[] result = biggestIncreasingSeq(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] biggestIncreasingSeq(int[] array)
    {
        int bestStart = 0;
        int bestEnd = 0;

        int start = 0;
        int end = 0;

        for (int i = 1; i < array.length; ++i)
        {
            // Check if this next element is no longer increasing
            if (array[i] <= array[i - 1])
            {
                // No longer increasing.

                // Update the largest found array, if applicable
                if (end - start > bestEnd - bestStart)
                {
                    // This was a longer sequence
                    bestEnd = end;
                    bestStart = start;
                }

                // Reset for the next sequence
                start = i;
                end = i;
            }
            else
            {
                // Still increasing, update the end
                end = i;
            }
        }

        // Save the sequence to a new array
        int[] result = new int[bestEnd - bestStart + 1];
        for (int i = bestStart; i <= bestEnd; ++i)
        {
            result[i - bestStart] = array[i];
        }

        return result;
    }
}