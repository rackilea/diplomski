public class ThreadLocalDateFormat extends ThreadLocal<DateFormat>
{
    private String dateFormat;

    public ThreadLocalDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }

    @Override
    protected DateFormat initialValue()
    {
        return new SimpleDateFormat(dateFormat);
    }
}