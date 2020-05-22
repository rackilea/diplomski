import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reverse
{
    static String[] inputArray = new String[5];

    public static void main(String[] args)
    {
        inputArray[2] = "John";
        inputArray[3] = "Sally";
        inputArray[4] = "Fred";

        int startIndex = 0;
        int endIndex = inputArray.length;

        boolean foundStart = false;
        boolean foundEnd = false;
        System.out.println("before sort");
        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.println(inputArray[index]);

            if (!foundStart && inputArray[index] != null)
            {
                startIndex = index;
                foundStart = true;
            }

            if (foundStart && !foundEnd && inputArray[index] == null)
            {
                endIndex = index;
                foundEnd = true;
            }
        }

        System.out.println("\nafter sort");
        List<String> swapList = Arrays.asList(Arrays.copyOfRange(inputArray, startIndex, endIndex));
        Collections.reverse(swapList);
        System.arraycopy(swapList.toArray(new String[swapList.size()]), 0, inputArray, startIndex, swapList.size());

        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.println(inputArray[index]);
        }
    }
}