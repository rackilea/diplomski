import java.util.ArrayList;

public class Sorting {  
    public static void main(String[] args) 
    {
        ArrayList<Integer> alInput = makeArray(5);

        // now you can get the sorted string :)
        String sortedResult = ArraySorter(alInput);
        System.out.println("The sorted array is : " + sortedResult);

    }
    public static String ArraySorter (ArrayList<Integer> alSort) 
    {
        int iMin = alSort.get(0);
        int iMinIndex = 0;
        for (int i = 0;i<alSort.size();i++ )
        {
            if (alSort.get(i)<iMin)
            {
                iMin = alSort.get(i);
                iMinIndex = i;
            }
        }
        alSort.remove(iMinIndex);

        // added this one in myself, this is your base case for preventing a stack overflow:
        if (alSort.size() == 0) {
            return String.valueOf(iMin);
        }

        return String.valueOf(iMin) + "," + ArraySorter (alSort); // changed from : String.valueOf(iMin) + ArraySorter (alSort);
    }

    public static ArrayList<Integer> makeArray(int iSize)
    {
        ArrayList<Integer> alNum = new ArrayList<Integer>();

        for (int i = 0; i<iSize;i++)
        {
            alNum.add((int )(Math.random() * 100 + 1));
        }
        System.out.println(alNum);
        return alNum;
    }
}