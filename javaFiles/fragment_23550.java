public class MyTask extends AsyncTask<Void, Void, Void>{
    private Context mContext;

    public MyTask(Context context){
        mContext = context;
    }

    ...
    ... 

    protected void onPostUpdate(Integer... progress){
        Toast toast= Toast.makeText(mContext, "Loaded A-Z", Toast.LENGTH_LONG);
        toast.show();
    }
}