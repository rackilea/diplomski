private boolean canDrawOnScreen() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return canDrawOnScreenM();
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        return canDrawOverlaysUsingReflection(getApplicationContext());
    } else
        return true;
}

@RequiresApi(api = Build.VERSION_CODES.M)
private boolean canDrawOnScreenM() {
    return Settings.canDrawOverlays(getApplicationContext());
}


@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public static boolean canDrawOverlaysUsingReflection(Context context) {
    try {
        AppOpsManager manager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        Class clazz = AppOpsManager.class;
        Method dispatchMethod = clazz.getMethod("checkOp", new Class[]{int.class, int.class, String.class});
        //AppOpsManager.OP_SYSTEM_ALERT_WINDOW = 24
        int mode = (Integer) dispatchMethod.invoke(manager, new Object[]{24, Binder.getCallingUid(), context.getApplicationContext().getPackageName()});
        return AppOpsManager.MODE_ALLOWED == mode;
    } catch (Exception e) {
        return false;
    }

}