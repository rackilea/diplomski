public static int largest(int[] nums3)
{
    if (nums3.length == 0) { return -1; } 
    int largestIndex = 0;
    for(int i=0; i < nums3.length; i++)
    {
        if(nums3[i] > nums3[largestIndex])
        {
            largestIndex = i;
        }

    }
    return largestIndex;
}