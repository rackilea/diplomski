public static void createLauncherPicker(Context context) {
    Log.v(">>>", "create launcher picker");
    PackageManager pm = context.getPackageManager();
    ComponentName cn1 = new ComponentName(GlobalValue.APP_NAME, GlobalValue.LAUNCHER_ALIAS_1); // Ex: "com.kidmod.android", "com.kidmod.android.LauncherAlias1"
    ComponentName cn2 = new ComponentName(GlobalValue.APP_NAME, GlobalValue.LAUNCHER_ALIAS_2);
    int dis = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
    if(pm.getComponentEnabledSetting(cn1) == dis) dis = 3 - dis;
    pm.setComponentEnabledSetting(cn1, dis, PackageManager.DONT_KILL_APP);
    pm.setComponentEnabledSetting(cn2, 3 - dis, PackageManager.DONT_KILL_APP);
}