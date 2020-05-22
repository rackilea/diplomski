PackageManager myPackageManager;

public AppDrawerAdapter(Context c, List<ResolveInfo> l){
    myContext = c;
    MyAppList = l;
    myPackageManager = c.getPackageManager();
}