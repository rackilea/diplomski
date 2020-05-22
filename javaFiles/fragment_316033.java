private ListView mList;

public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    // ...
    mlist = ...
    new LoadAllProducts(this, username, params, ...); // PASS ALL THE PARAMTERS THE ASYNCTASK NEEDS
}

public void populateList(ArrayList<HashMap<String, String>> productsList) {
    mList.setAdapter(new CustomInventoryList(this, productsList));
}

static class LoadAllProducts extends AsyncTask<String, String, JSONObject> {
    private String username;
    private List<NameValuePair> params;
    private Activity mActivity;

    public LoadAllProducts(...) {
        username = ...;
        params = ...;
        mActivity = ...;
    }

    @Override
    protected String doInBackground(String... args) {
        ...

        // getting JSON string from URL
        json = jParser.makeHttpRequest(url_all_products, "GET", params);

        return json;
   }


   protected void onPostExecute(JSONObject json) {
        try {
           // Checking for SUCCESS TAG
           int success = json.getInt(TAG_SUCCESS);

           if (success == 1) {
               // ... handle your JSON
           }
       } catch (JSONException e) {
           e.printStackTrace();
       }

       mActivity.populateList(productsList);
   }
}