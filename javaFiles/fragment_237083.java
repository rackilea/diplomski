public class NewAlertAsyncTask extends AsyncTask<String, String, Boolean> {

    Context context;

    private WebApiMethodsController webApiMethodsController;
    AuthenticatedUser authenticatedUser;

    public NewAlertAsyncTask(Context ctx) {
        this.context = ctx;
        authenticatedUser = AuthenticatedUser.getIstance(context);
        webApiMethodsController = new WebApiMethodsController(authenticatedUser.getAuthenticationTokenID().toString(), authenticatedUser.getResourceID().toString(), context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
    }

    @Override
    protected Boolean doInBackground(String... datas) {
        Boolean result;
        try {
            result = webApiMethodsController.setAlerts(datas[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    protected void onPostExecute(Boolean s) {
        if(s){
            //manage succes, I use this
            mCallback.onNewAlertCreated();
        }
        else{
            //manage error
        }
    }
}