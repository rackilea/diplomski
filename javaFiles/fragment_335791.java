private static final boolean REGISTER_DUPLICATE_RECEIVER = VERSION.SDK_INT <= VERSION_CODES.LOLLIPOP_MR1;

if (REGISTER_DUPLICATE_RECEIVER) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        filter.addDataScheme("package");
        context.registerReceiver(this, filter);
    }