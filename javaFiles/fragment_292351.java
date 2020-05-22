List<ResolveInfo> browserList;
if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.MARSHMALLOW) {
    browserList = pm.queryIntentActivities(intent, PackageManager.MATCH_ALL);
} else {
    browserList = pm.queryIntentActivities(intent, 0);
}