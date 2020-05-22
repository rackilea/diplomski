public class Generic_Class<T> where T : struct, IConvertible
{
    T[] nums;
    public Generic_Class(T[] o)
    {
        nums = o;
    }

    public double Average()
    {
        double sum = 0.0;
        for(int i=0; i < nums.Length; i++)
            sum += nums[i].ToDouble(null);
        return sum / nums.Length;
    }

    // this is the important bit
    public bool SameAvg<U>(Generic_Class<U> ob) where U : struct, IConvertible
    {
        if(Average() == ob.Average())
            return true;
        return false;
    }
}