for(int x = 0; x < array1.length; x++)
{
    boolean isFruit = true;
    for(int y = 0; y < array2.length; y++)
    {
        if(array1[x].equals(array2[y]))
        {
            System.out.println(array1[x] + "\t" + array2[y]);
            isFruit = false;
        }
        if(isFruit)
        {
            fruits.add(array1[x]);
        }
    }//end for loop
}//end for loop