// various input calls above^ to create array
int count = 0;
for(int i = 0; i < array.length; i++)
{
    for(int j = i + 1; j < array.length; j++)
    {
        if(array[i] + array[j] == 0)
        {
            System.out.println("The numbers " + array[i] + " and " +
                               array[j] + 
                               " have a sum equal to zero.");
            count++;
        }
     }
}

if(count == 0)
{
    System.out.println("No sum between any numbers is equal to 0");
}