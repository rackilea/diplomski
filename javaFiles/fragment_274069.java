public static void StringCount(String [] Array)
{
    int size = Array.length;
    Set<String> existingElement = new HashSet<>();
    for (int i = 0; i < size; i++)
    {
        int count = 0;

        String element = Array[i];

        for (int j = 0; j < size; j++)
        {
            if (Array[j].equals(element)){
                count ++;
            }
        }
        // This will print the result if and only if the element has not
        // already been added into the Set
        if (existingElement.add(Array[i])) {
            System.out.println(Array[i] + " " + count);
        }
    }
}