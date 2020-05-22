private static int[][] getMatrix(int limit)
{
    int[] array = new int[limit];
    for (int i=2; i<limit; i++)
        array[i] = sumFactors(i);

    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for (int i=2; i<limit; i++)
    {
        int j = array[i];
        if (j < i && i == array[j])
            map.put(i,j);
         // Check 'j < i' in order to:
         // 1. Avoid an illegal index when 'j >= limit'
         // 2. Avoid the insertion of the equivalent pair [j,i]
         // 3. Avoid the insertion of perfect numbers such as [6,6]
    }

    int[][] matrix = new int[map.size()][2];
    int index = 0;
    for (int key : map.keySet())
    {
        matrix[index][0] = key;
        matrix[index][1] = map.get(key);
        index++;
    }
    return matrix;
}