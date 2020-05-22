Integer[] numbers = new Integer[numberStrs.length];
for(int i = 0;i < numberStrs.length;i++)        
{
    try 
    {
        numbers[i] = Integer.parseInt(numberStrs[i]);
    }
    catch (NumberFormatException nfe)   
    {
        numbers[i] = null;
    }
}