public class RequestTask extends AsyncTask...{
    private Context context;
    //.........
    public RequestTask(Context context){
        this.context = context;
    }
    //.........
    //Now in the onPostExecute, just use the Context object to grab the view
    public void onPostExecute(String result){
       TextView httpStuff = (TextView) context.findViewById(R.id.datadisplay);
       httpStuff.setText(result);
    }