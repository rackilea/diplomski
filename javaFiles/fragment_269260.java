int numberOfNonSystemApps = 0;

List<ApplicationInfo> appList = getPackageManager().getInstalledApplications(0);
for(ApplicationInfo info : appList) {
    if((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
        numberOfNonSystemApps++;
    }
}