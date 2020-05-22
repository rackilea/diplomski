int max = 0;
//int test = 0;
for (int counter = 0; counter < countOfArray.length; counter++)
{
    if (countOfArray[counter] >= max)
    {
        max = countOfArray[counter];
        //test = counter + 1;
    }
}

System.out.print("The number that appears the most is");
boolean first = true;
for(int i = 0; i < countOfArray.length; i++)
{
    if(countOfArray[i] == max)
    {
        if(first)
            first = false;
        else
            System.out.print(",");
        System.out.print(" " + (i+1) );
    }
}
System.out.println(".");