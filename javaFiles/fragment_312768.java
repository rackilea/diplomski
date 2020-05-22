public class Background extends AsyncTask<Void,Void,Void> {
    private Context context;

    public Background(Context context){
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Intent intent = new Intent(context, TargetActivity.class);
        context.startActivity(intent);
        ((Activity)context).finish();
    }
}