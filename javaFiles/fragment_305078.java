public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Viewhold> {
ArrayList<PInfo> appn;
    public CustomAdapter() {
       appn=p.getInstalledApps(true);
    }

    @Override
    public int getItemCount() {

          return appn.size();
    }

    @Override
    public void onBindViewHolder(Viewhold holder, int pos) {
      for(int i=0;i<appn.size();i++{
          holder.appname.setText(appn.get(i).pname);
       }
   }

   @Override
   public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.yourlayout, viewGroup, false);
        return new ContactViewHolder(itemView);
   }


private ArrayList<PInfo> getPackages() {
        ArrayList<PInfo> apps = getInstalledApps(false); /* false = no system packages */
        final int max = apps.size();
        for (int i=0; i<max; i++) {
            apps.get(i).prettyPrint();
        }
        return apps;
    }

private ArrayList<PInfo> getInstalledApps(boolean getSysPackages) {
    ArrayList<PInfo> res = new ArrayList<PInfo>();        
    List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
    for(int i=0;i<packs.size();i++) {
        PackageInfo p = packs.get(i);
        if ((!getSysPackages) && (p.versionName == null)) {
            continue ;
        }
        PInfo newInfo = new PInfo();
        newInfo.appname = p.applicationInfo.loadLabel(getPackageManager()).toString();
        newInfo.pname = p.packageName;
        newInfo.versionName = p.versionName;
        newInfo.versionCode = p.versionCode;
        newInfo.icon = p.applicationInfo.loadIcon(getPackageManager());
        res.add(newInfo);
    }
    return res; 
}
  public static class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView appname;
        public ViewHolder(View v) {
        super(v);
        appname = (TextView) v.findViewById(R.id.appname);
    }
   }
}