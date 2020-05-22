List<Intent> targetedShareIntents = new ArrayList<Intent>();
Intent sharingIntent = new      Intent(android.content.Intent.ACTION_SEND);
sharingIntent.setType("text/plain");
PackageManager pm =v.getContext().getPackageManager();
List<ResolveInfo> activityList =   pm.queryIntentActivities(sharingIntent, 0);

for(final ResolveInfo app : activityList) {
    String packageName = app.activityInfo.packageName;
    Intent targetedShareIntent = new Intent(android.content.Intent.ACTION_SEND);
    targetedShareIntent.setType("text/plain");
    targetedShareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "share");

    if(TextUtils.equals(packageName, "com.facebook.katana")){
        targetedShareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "http:your link");
    } else {
        targetedShareIntent.putExtra(android.content.Intent.EXTRA_TEXT, strLink);
        targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT, " app version");
    }
    targetedShareIntent.setPackage(packageName);
    targetedShareIntents.add(targetedShareIntent);
}

Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0), "Share Application  your app name ");
chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.toArray(new Parcelable[]{}));
startActivity(chooserIntent);