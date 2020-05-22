public class ChooseLocationTask extends AsyncTask<String, Void, Void> {

    private final OkHttpClient client = new OkHttpClient.Builder()
            //default timeout for not annotated requests
            .readTimeout(15000, TimeUnit.MILLISECONDS)
            .connectTimeout(15000, TimeUnit.MILLISECONDS)
            .writeTimeout(15000, TimeUnit.MILLISECONDS)
            .build();
    private final Request request;


    private final TextView location;
    private final TextView value;
    String state;
    Number probability;
    String probablityString;

    public ChooseLocationTask(TextView location, int selected, TextView value){
        this.location = location;
        this.value = value;
    }

    @Override
    protected Void doInBackground(String... urls) {
        request = new Request.Builder().url(urls[0]).build();

        try {
            final Response<?> response = client.newCall(request).execute();
            if(response.isSuccessful()) {
                final JSONObject jsonObject = new JsonObject(response.body().string());
                //etc...
            }
        } catch (IOException e) {
           //...
        }

        //I'd recommend you return values as well, rather than assigning them to
        //instance variables
        return null;
    }

    @Override
    protected void onPostExecute(Void voids){
        if(isCancelled()){
            voids= null;
        } else {
            location.setText(state);
            value.setText("your chance to see Northern lights today is" + probablityString);
            Log.d("value", "onPostExecute: " + probablityString);
        }
        Log.d("post", "onPostExecute: " + probability);
    }