public class FirstAsyncTask extends AsyncTask<ServiceParams, Void, Void> {
    String resp = "";
    ProgressDialog progressDialog;

    @Override
    protected Void doInBackground(ServiceParams... params) {
        resp = WebService.invoke(params[0].properties, params[0].methodName);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

        Log.w("WEBSERVICE RESPONSE===", resp);

        try {
            JSONArray ja = new JSONArray(resp);
            Utils.subMenuArrayList.clear();
            Info_Item info_item=new Info_Item(ja.getJSONObject(0));
            ((TextView)findViewById(R.id.txtInfo)).setText(info_item.getInfo());
            ((TextView)findViewById(R.id.txtModule)).setText(Utils.selectedMenuName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(Info.this);
        if (progressDialog != null) {
            progressDialog.setCancelable(false);
            progressDialog.setMessage("İşlem yapılıyor ...");
            progressDialog.show();
        }
    }

    protected void onProgressUpdate(Integer... progress) {
        if (progressDialog != null)
            progressDialog.setProgress(progress[0]);
    }

}