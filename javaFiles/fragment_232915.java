public class NextValueService
{
    @Handler
    public Integer nextValue(Integer value)
    {
        return new Integer(value.intValue() + 1);
    }
}