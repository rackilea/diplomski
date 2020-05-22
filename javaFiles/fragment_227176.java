public class UpdateApp extends AsyncTask<String,Void,Void> {
    private TextView status;
    public UpdateApp(TextView status){
        this.status = status;
    }
    @Override
    protected void onPostExecute(String result) {
        status.setText("Update complete");
    }

    @Override
    protected void onPreExecute() {
         status.setText("Checking for updates...");
    }
    @Override
    protected Void doInBackground(String... arg0) {

        // Update the app

    }
}