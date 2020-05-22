new MuckException(){ public void run() throws Exception
{
    statement_1;
    ...
    statement_n;
}};

public abstract class MuckException
{
    public abstract run() throws Exception;

    public MuckException()
    {
        try{ run(); }
        catch(Exception e){ throw new Error(e); }
    }
}