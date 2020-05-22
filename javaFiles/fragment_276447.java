// Each <animal> element has already been stored in an array called 'zoo'
for( int i = 0; i < zoo.length; i++) 
{
    ...

    // get the names for this breed
    ArrayList<String> expectedNames = expectedBreeds.get(thisExpectedBreed);
    // if there aren't any, start a new collection
    if (expectedNames == null)
    {
        expectedNames = new ArrayList<String>();
        expectedBreeds.put(thisExpectedBreed, expectedNames);
    }
    expectedNames.add(thisExpectedName);
    ...