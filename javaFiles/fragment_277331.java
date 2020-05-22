// ...
private Context mAppContext = null;
private static MySingleton mSingleton = null;
// ...

private MySingleton(Context context) {
    mAppContext = context;
    // ... other initialization
}

public static MySingleton get(Context context) {
    if (mSingleton == null) {
        /*
         * Get the global application context since this is an
         * application-wide singleton
         */
        mSingleton = new MySingleton(
                context.getApplicationContext());
    }
    return mSingleton;
}