public final class MyUtils {

    public static ArrayList<CharSequence> getPackageNames(final Context context){
        ArrayList<CharSequence> packageNames = new ArrayList<>();
        List<PackageInfo> packagesInfos = context.getPackageManager().getInstalledPackages(0);

        for(PackageInfo packageInfo: packagesInfos){
            if(!isSystemApp(packageInfo)){
                packageNames.add(packageInfo.packageName);
            }
        }

        return packageNames;
    }
    private static boolean isSystemApp(...){
        ...
    }
}