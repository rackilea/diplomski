public abstract class ResponseHandler 
{
    private Context context;

    public abstract void execute (JSONObject jsonObject) throws JSONException;

    public ResponseHandler (Context ctx)
    {
        this.context = ctx;
    }

    public void handleObject(JSONObject jsonObject) throws Exception
    {
        execute(jsonObject);

    }
}