public class ReturnFormat
{
    private Status status;
    private String message;
    private Object data;

    public ReturnFormat()
    {
    }

    public ReturnFormat( Status status, String message, Object data )
    {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus( Status status )
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public Object getData()
    {
        return data;
    }

    public void setData( Object data )
    {
        this.data = data;
    }

    public enum Status
    {
        SUCCESS, ERROR, CREATED, UPDATED, DELETED, FOUND, NOT_FOUND
    }

}