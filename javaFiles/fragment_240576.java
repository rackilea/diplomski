public class your_service extends Service {


public your_service() {
}

@Override
public IBinder onBind(Intent intent) {
    return null;
}

@Override
public void onCreate() {
    super.onCreate();

}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    final Handler handler = new Handler();

    handler.postDelayed(new Runnable() {
    public void run() {
    request = new StringRequest(Request.Method.POST, your_url, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
       // add code, ur logic
       //notify here
       //                         
     }
    }, 
       new Response.ErrorListener() {
       @Override
       public void onErrorResponse(VolleyError error) 
             {//empty
             }
          });

        Volley.newRequestQueue(getBaseContext()).add(request);
        handler.postDelayed(this, 60000); //repeat this code every 1 minutes
             }
          }, 1000); // first wait for 1 seconds
        }
       }
    };
    return START_STICKY;
}
}