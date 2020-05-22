public class RetrieveApps extends AsyncTask<String, Void, List<ApplicationInfo>> {
    PackageManager pm;

    @Override
    protected List<ApplicationInfo> doInBackground(String...params) {

        pm = getPackageManager();
        return pm.getInstalledApplications(PackageManager.GET_META_DATA);
    }
    @Override
    protected void onPostExecute(List<ApplicationInfo> result) {
        for(ApplicationInfo nfo : result){
            Drawable icon = nfo.loadIcon(pm);
            String name = nfo.loadLabel(pm).toString();
            if(name != null && icon != null){
                apps.add(new App(name, icon));
            }
        }
        dialog.dismiss();
    }

    @Override
    protected void onPreExecute(){
      dialog = ProgressDialog.show(Apps.this,
                "Retreiving Application list",
                "Retrieving list of installed applications", true);

    }

}