public class BackgroundService extends Service implements LocationListener,
    SensorEventListener{


//Hint: there are some methods you need to implement which I forgot to mention but eclipse will add them for you

@Override
public void onCreate() {



    //enable networking, look into this: http://www.vogella.com/blog/2012/02/22/android-strictmode-networkonmainthreadexception/

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    //do your data collecting-methods and connect to your webserver


}

@Override
public void onDestroy() {
       //unregister your sensor listener

}

}