Intent intent = new Intent(Intent.ACTION_MAIN);
intent.addCategory(Intent.CATEGORY_HOME);
PackageManager pm = context.getPackageManager();
pm.setComponentEnabledSetting(new ComponentName(context, CustomLauncherActivity.class),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_ALL);
pm.setComponentEnabledSetting(new ComponentName(context, CustomLauncherActivity.class),
PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
String currentHomePackage = resolveInfo.activityInfo.packageName;
String customlauncherpackage = context.getApplicationContext().getPackageName();