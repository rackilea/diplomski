for(int i = 0; i < array.length; i++)
{
    if(array[i] == numChosen)
    {
        System.out.println(numChosen + " was found.");
        return;
    }
}
System.out.println(numChosen + " was not found.");