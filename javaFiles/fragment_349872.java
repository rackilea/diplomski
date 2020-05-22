public static void main(String[] args)
{
    Random rand = new Random();
    long beforeNS = 0;
    long afterNS = 0;
    int results[] = { 0, 0 };
    int runs = 100;
    for (int size=10000; size<=10000000; size*=2)
    {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(size) - 144;

        beforeNS = System.nanoTime();
        for (int i=0; i<runs; i++)
        {
            nonEfficient(array, results);
        }
        afterNS = System.nanoTime();
        System.out.println(
            "Not efficient, size "+size+
            " duration "+(afterNS-beforeNS)/1e6+
            ", results "+Arrays.toString(results));

        beforeNS = System.nanoTime();
        for (int i=0; i<runs; i++)
        {
            efficient(array, array.length, results);
        }
        afterNS = System.nanoTime();
        System.out.println(
            "Efficient    , size "+size+
            " duration "+(afterNS-beforeNS)/1e6+
            ", results "+Arrays.toString(results));
    }
}