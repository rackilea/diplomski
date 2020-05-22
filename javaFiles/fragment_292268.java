public int[] findAll(int arr[], int num)
{
    int indexNum = 0;
    int arrSize = 0;

    // find all accutences of the target
    for(int x = 0; x < arr.length; x++)
    {
        if(arr[x] == num)
        {
            arrSize++;
        }
    }
    //create new array with the right occurence size
    int newArr[] = new int[arrSize];
    for(int x = 0; x < arr.length; x++)
    {
        if(arr[x] == num)
        {
            newArr[indexNum] = x;
            indexNum++;
        }
    }
    return newArr;
}

public void print(int arr[])
{
    System.out.print("{");
    int i;
    // print elements before the last, separated by commas
    for (i = 0; i < arr.length - 1; ++i)
        System.out.print(arr[i] + ", ");
    // print last element.  Careful here to handle length 0
    if (arr.length > 0)
        System.out.print(arr[i]);
    System.out.print("}\n");
}