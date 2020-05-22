public class LoaderAsyncTask extends AsyncTask<Void, PackageInfo, Void> {
    ProgressDialog mDialog;
    private ArrayList<PackageInfo> mList = new ArrayList();
    public LoaderAsyncTask()
    {
        mDialog = ProgressDialog.show(mActivity, "Loading", "Pls wait a moment...");
        mList.clear();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try
        {
            refreshAppList();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private void refreshAppList() {
        PackageManager pkgMgr = mActivity.getPackageManager();
        List<PackageInfo> pgs = pkgMgr.getInstalledPackages(PackageManager.GET_PERMISSIONS);
        for (int i = 0; i < pgs.size(); i++) 
        {
                    if(isCancelled())
                        break;
                    PackageInfo p = pgs.get(i);
                   mList.add(p);
        }
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mDialog.dismiss();
      //  mGridAdapter.setData(mList);//now you will get update app list , set to your GridAdapter refresh the Launcher.
    }
}