public static int getFirstLaunch(Context context) {
    return getBoolean(context, FIRST_LAUNCH, true);
}

public static int saveFirstLaunch(Context context, boolean value) {
    return saveBoolean(context, FIRST_LAUNCH, value);
}