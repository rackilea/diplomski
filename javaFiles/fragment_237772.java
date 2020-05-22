public class Main
{
    public static void sort(int[] array) 
    {
        /* TODO: add code here */
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) 
    {
        int i = start;
        int j = end;
        int pivot = array[(start+end)/2];

        while (i <= j)
        {
            while (array[i] < pivot) 
            {
                i++;
            }

            while (pivot < array[j]) 
            {
                j--;
            }

            if (i <=j)
            {
                int h = array[i];
                array[i] = array[j];
                array[j] = h;
                i++;
                j--;
            }
        }

        if (start < i-1)
        {
            sort(array, start, i - 1);
        }

        if (i < end) 
        {
            sort(array, i, end);
        }
    }

    public static boolean binSearch(int[] array, int elem) 
    {
        /* TODO: add code here */

        int i = 0; //the first element
        int j = array.length -1; // the last element
        int k = i + ((i+j)/2); //try the middle word

        while (k >= 0 && k < array.length) 
        {
            if (elem == array[k])
            {
                return true;
            }

            if (elem < array[k]) 
            {
                k--;
            }

            else
            {
                k++;
            }
        }

        return false;
    }

    //just for testing
    public static void main(String[] args)
    {
        int[] arr = new int[] {5, 3, 7, 2, 1, 6};

        sort(arr);

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }

        if (binSearch(arr,5))
        {
            System.out.println("TRUE");
        }
    }
}