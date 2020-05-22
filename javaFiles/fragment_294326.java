private ArrayList<ResolveInfo> checkForLauncherIntent(List<ApplicationInfo> list){

    ArrayList<ResolveInfo> mItems = new ArrayList();

    for(ApplicationInfo info : list) {
        try{
            if(packageManager.getLaunchIntentForPackage(info.packageName) != null) {
                Intent intent = packageManager.getLaunchIntentForPackage(info.packageName));
ResolveInfo app = packageManager.resolveActivity(intent,0);
mItems.add(app);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    return mItems;
}