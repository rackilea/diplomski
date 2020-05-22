public class TestVolley {

    private String TAG = "SO_TEST";
    private String url = "http://pokeapi.co/api/v2/pokemon-form/1/";


    public JSONObject fetchModules(Context ctx){
        JSONObject response = null;
        RequestQueue requestQueue = Volley.newRequestQueue(ctx);


        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(url,null,future,future);
        requestQueue.add(request);


        try {
            response = future.get(3, TimeUnit.SECONDS); // Blocks for at most 10 seconds.
        } catch (InterruptedException e) {
            Log.d(TAG,"interrupted");
        } catch (ExecutionException e) {
            Log.d(TAG,"execution");
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Log.d(TAG,response.toString());

        return response;
    }
}