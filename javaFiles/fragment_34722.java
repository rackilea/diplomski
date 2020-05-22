public class ProgressModel implements IModel<String>
{
    private static final long serialVersionUID = 1L;

    public String status;

    @Override
    public void detach ()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public String getObject ()
    {
        return status;
    }

    @Override
    public void setObject (String object)
    {
        status = object;
    }
}