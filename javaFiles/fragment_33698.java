int index = 0;
for(int i = 0;i < numberStrs.length;i++)
{
    try
    {
        numbers[index] = Integer.parseInt(numberStrs[i]);
        index++;
    }
    catch (NumberFormatException nfe)
    {
        //Do nothing or you could print error if you want
    }
}
// Now there will be a number of 'invalid' elements 
// at the end which will need to be trimmed
numbers = Arrays.copyOf(numbers, index);