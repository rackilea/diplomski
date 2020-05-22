public class TestCode
{
static int[] array = {2,1,5,3,5,4,9,1,99,7};


public void sort(int[] arrays)
{

    for(int i = 0; i < arrays.length - 1 ;i++ )
    {
        int store = 0;
        // Move larger values to the right
        if (arrays[i] > arrays[i + 1])
        {
            store = arrays[i];
            arrays[i] = arrays[i + 1];
            arrays[i + 1] = store;
            // Sort swapped smaller values to the left
            for(int j = i; j > 1; j--)
            {
                if (arrays[j] < arrays[j - 1])
                {
                    store = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = store;
                }
            }

        }
    }

    for(int i = 0; i < array.length; i ++)
    {
        System.out.print(arrays[i] + " ");
    }
    System.out.println();
}

public void reverse (int[] arrays)
{   
    for (int i=arrays.length-1; i >=0; i--)
    {
        System.out.print(arrays[i] + " ");
    }


}
/**
 * @param args
 */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        TestCode sort = new TestCode();
        sort.sort(array);
        sort.reverse(array);

    }

}