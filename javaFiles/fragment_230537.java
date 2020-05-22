public interface ProcessResponse<T>
{
    void process(T response);
}

public class AcquireResponseTask<T> extends AsyncTask<RestClient, Void, T> 
{
    private Class<T> type;
    private ProcessResponse<T> func;

    public AcquireResponseTask(Class<T> classType, ProcessResponse<T> f)
    {
        type = classType;
        func = f;
    }

     protected void onPostExecute(T response) 
     {
         func.process(response);
     }

    @Override
    protected T doInBackground(RestClient... rc)
    {
        return (T) JSONToJava.acquireResponse(rc[0],
                type);
    }
 }