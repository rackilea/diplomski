PackageManager pm = getPackageManager();

Method getPackageSizeInfo = pm.getClass().getMethod("getPackageSizeInfo", String.class, IPackageStatsObserver.class);

getPackageSizeInfo.invoke(pm, "com.android.mms", new IPackageStatsObserver.Stub() {

    @Override
    public void onGetStatsCompleted(PackageStats pStats, boolean succeeded)
        throws RemoteException {

        Log.i(TAG, "Size of the installed app: " + pStats.codeSize);
    }
});