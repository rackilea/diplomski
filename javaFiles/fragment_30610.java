public static void checkEachNumber(int[] array)
{
    int currentNum = 0;
    for(int i = 0; i < array.length; i++)
    {
        int flag=0;
        for(int j = 0; j < array.length; j++)
        {
            currentNum = i;
            if(currentNum == array[j])
            {
                System.out.println(currentNum + " appears in the array");
                flag=1;
                break;
            }

        }
        if(flag==0)
        {
              System.out.println("currentNum+"Doesn't appear in array");
        }
    }
}