private class LoadApplications extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... params){
       ArrayList<ResolveInfo> mItem = checkForLauncherIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));

      listViewAdapter = new ListViewAdapter(ctx, mItem);


        return null;
    }


    @Override
    protected void onPostExecute(Void result){
        super.onPostExecute(result);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ResolveInfo resolveInfo = listViewAdapter.getItem(position);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                ComponentName name = new ComponentName(activityInfo.applicationInfo.packageName,activityInfo.name);

                Intent intent = new Intent();
                intent.setComponent(name);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        //progressDialog = ProgressDialog.show(getActivity(), null, "Loading file info...");

    }
}