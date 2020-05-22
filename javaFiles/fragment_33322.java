public String toString(int[] nums)
{
    StringBuilder strang = new StringBuilder(length);
    for ( int i = 0 ; i < length; i++ )
    {
        strang.append("Index: ").append(i).append(" Number: ").append(nums[i]).append(", ");
    }
    return strang.toString();
}