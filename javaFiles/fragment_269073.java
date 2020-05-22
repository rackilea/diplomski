public static void PrintMagic(int n)
{
    int count = 0;
    int[] array = new int[n];
    int magic = 0;
    for(int i = 0; count < n; i++)
    {
        magic += i;
        if(Math.sqrt(magic) == ((int)Math.sqrt(magic)))
        {
            array[count] = magic;
            count++;
        }
    }
    for(int i = 0; i<array.length; i++)
    {
        System.out.println(array[i]);
    }
}