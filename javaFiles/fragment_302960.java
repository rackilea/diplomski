public class Courier
{
    private String[] data;

    public String[] getData ()
    {
        return data;
    }

    public void setData (String[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }
}