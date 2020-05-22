public static int secondMaxIndex(ArrayList<Integer> intArray)
  {
    int largest  = intArray.get(0);
    Integer largest2 = null;
    int maxIndex = 0;
    int maxIndex2 = 0;

    for( int i = 0; i < intArray.size() ; i++)
    {
        if( largest < intArray.get(i) )
        {
            largest2 = largest;
            maxIndex2 = maxIndex;
            largest = intArray.get(i);
            maxIndex = i;
        }
        else if(largest2 == null || intArray.get(i) > largest2)
        {
             largest2 = intArray.get(i);
             maxIndex2 = i;
        }
    }

    return maxIndex2;
}