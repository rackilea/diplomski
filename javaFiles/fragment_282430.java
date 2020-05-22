public void consolidate()
{
    int lengthOfSpaces = spaces.length , i, numberOfEmpties = 0;
    Type[] spacesNumberTwo = new Type[lengthOfSpaces ];

    // pass 1: find empties
    for (i = 0; i < lengthOfSpaces ; i++)
    {
        if(spaces[i].getName().equals("no name") == false)
             spacesNumberTwo[i] = new Type(spaces[i].getName(), spaces[i].getInt());
        else
          numberOfEmpties++;
    }
    for (i = lengthOfSpaces - 1; numberOfEmpties > 0 ; numberOfEmpties--, i--)
    {
           spacesNumberTwo[i] = new Type("no name", 0);
    }
    spaces = spacesNumberTwo
}