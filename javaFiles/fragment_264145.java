public class JSONTask extends AsyncTask<String,String,String>{
    private OnHandleResult mResult;
    private String[] mParams;
    public JSONTask(OnHandleResult onHandleResult,String... params){
        this.mResult = onHandleResult;
        this.mParams = params;
    }

    protected String doInBackground(String... params){
    //params is empty,get params from this.mParams
    }

     @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        //json_output.setText("result:" +result);
        this.mResult.handleResult(result);
    }

    public static interface OnHandleResult{
        void handleResult(final String result);
    }
}