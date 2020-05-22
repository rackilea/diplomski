public class YourSocketClass
{
private ResponseHandler handler;

public static void initInstance(your parameter, ResponseHandler responseHandler)
{
    this.handler = responseHandler;

    // Do your operations here      
}

@Override
public void on(String event, IOAcknowledge ack, Object... args) 
{
    JSONArray jarr_args = new JSONArray();
    JSONObject jobj_in = new JSONObject();
    if (event.equals("registration_status")) 
    {
        jarr_args.put(args[0]);
        try 
        {
            jobj_in = jarr_args.getJSONObject(0);
            Log.d("Result", jobj_in.getString("result"));
            if (jobj_in.getString("result").equals("success")) 
            {
                //If you want to pass your jsonobject from here to activity
                //Do something like this
                handler.handleObject(jobj_in);
            } 
            else 
            {
                Log.d("check:", "username and password");
            }
        } 
        catch (JSONException e) 
        {
            e.printStackTrace();
        }
    }
}
}