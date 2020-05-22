private final MyListener mListener = new MyListener(){

    @Override
    public void onComplete(JSONArray result) {

    // TODO: Here you will get the Jsonarray from Asynctask. 
    // Process it and get the values.
    blogData = result;
    articleList();
    }
 }