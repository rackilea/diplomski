public class stackLong
{
    static char[] array = {'1', 'a', 'B', '2', 'h', '3', 'C', 'Z', '$', 'o', '5'};
    public static void main(String[] args) 
    {
        int number=0,small=0,capital=0,special=0;
        //calculates the total number of characters of each type
        for(int i =0; i<array.length;i++)
        {
            if (array[i]>=65 && array[i]<=90)  // capital
                capital++;
            else if (array[i]>=97 && array[i]<=122) //small
                small++;
            else if (array[i]>=48 && array[i]<=57)  // number 
                number++;
            else if ((array[i]>0 && array[i]<=47)||(array[i]>=58 && array[i]<=64)|| (array[i]>=91 && array[i]<=96)||(array[i]>=123 && array[i]<=127))
                special++;
        }

        // sets their starting index
        int smallIndex = number;
        int capitalIndex = small + smallIndex;
        int specialIndex = capitalIndex + capital;
        number = 0;

        for(int i =0; i<array.length;i++)
        {
            if (array[i]>=48 && array[i]<=57)  // number
            {
                swap(i,number);
                number++;
            }
        }

        for(int i =smallIndex; i<array.length;i++)
        {
            if (array[i]>=97 && array[i]<=122) //small
            {
                swap(i,smallIndex);
                smallIndex++;
            }
        }

        for(int i =capitalIndex; i<array.length;i++)
        {
            if (array[i]>=65 && array[i]<=90)  // capital
            {
                swap(i,capitalIndex);
                capitalIndex++;
            }
        }

        for(int i =specialIndex; i<array.length;i++)  // special
        {
            if ((array[i]>0 && array[i]<=47)||(array[i]>=58 && array[i]<=64)|| (array[i]>=91 && array[i]<=96)||(array[i]>=123 && array[i]<=127))
            {
                swap(i,specialIndex);
                specialIndex++;
            }
        }

        System.out.printf("\n");
        for(int j =0; j<array.length;j++)
        {
            System.out.printf(array[j] + " ");
        }
    }

    public static void swap(int frst, int scnd)
    {
        char temp = array[frst];
        array[frst] = array[scnd];
        array[scnd] = temp;
    }
}