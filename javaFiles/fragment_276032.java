while (i < sizeOfArray && j < sizeOfArray)
{
    if (i != j && (array[j] - array[i] == diff))
    {
        Pair newPair = new Pair(array[j], array[i]);
        differencePairs.add(newPair);

        // increment both here
        i++;
        j++;
    }

    // rest of loop
}