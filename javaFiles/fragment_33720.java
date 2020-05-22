public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getData();

}

private synchronized void getData() {
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    AndroidNetworking.initialize(this, okHttpClient);

    AndroidNetworking.get("https://www.aparat.com//etc/api/mostviewedvideos")
            .setPriority(Priority.HIGH)
            .addHeaders("Content-Type", "application/json")
            .build()
            .getAsJSONObject(new JSONObjectRequestListener() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String aparat = response.getString("mostviewedvideos");

                        JSONArray jsonArray = new JSONArray(aparat);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String title = jsonObject.getString("title");
                            String small_poster = jsonObject.getString("small_poster");
                            String sdate = jsonObject.getString("sdate");
                            String username = jsonObject.getString("username");

                            Log.i("data", title + "\n" + small_poster + "\n" + sdate + "\n" + username + "\n");
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(ANError anError) {
                    errorHandler(anError);
                }
            });
}

public void errorHandler(ANError error) {
    if (error.getErrorCode() != 0) {

        Log.e("onError errorCode", "onError errorCode : " + error.getErrorCode());
        Log.e("onError errorBody", "onError errorBody : " + error.getErrorBody());
        Log.e("onError errorDetail", "onError errorDetail : " + error.getErrorDetail());

    } else {
        Log.e("onError errorDetail", "onError errorDetail : " + error.getErrorDetail());
        Log.e("onError errorBody", "onError errorBody : " + error.getResponse());

    }
}

}