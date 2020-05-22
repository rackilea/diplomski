public static void install(Context context) {
    Log.i("MultiDex", "install");
    if(IS_VM_MULTIDEX_CAPABLE) {
        Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
    } else if(VERSION.SDK_INT < 4) {
        throw new RuntimeException("Multi dex installation failed. SDK " + VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
    } else {
        // Set up multidex
        ...
    }
}