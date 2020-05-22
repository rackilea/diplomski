public class scan extends AsyncTask<String, Integer, String> 
{

     public Object WIFI_SERVICE;
     public Context context;   // Context variable

     public scan(Context c)  // constructor to take Context
     {
         context = c;   // intialize your Context variable
     }