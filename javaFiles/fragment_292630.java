public class Baggage
    extends WeightedItem
{
    // ....

    public void setWeight(int weight)
        throws WeightException
    {
        if (overweight)
            throw doException(weight);
    }
}