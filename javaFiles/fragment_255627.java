String packageName = "";
for(ResolveInfo resInfo : resolvedInfoList) {

    packageName = resInfo.activityInfo.applicationInfo.packageName;

    // Exclude `packageName` from the dialog/popup that you show

}