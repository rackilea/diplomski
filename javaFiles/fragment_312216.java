public static void main(String[] args)
{
    int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10 };

    int sum = 0;
    for (int j = 0; j < array.length; j++)
    {
        for (int k = j + 1; k < array.length; k++) 
        {
            if (k != j && array[k] == array[j])
            {
                sum = sum + array[k];
                System.out.println("Duplicate found: " + array[k] + " " + "Sum of the duplicate value is " + sum);
            }
        }
    }
}