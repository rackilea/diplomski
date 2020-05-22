public ScanCollector(Context context, WifiScanner.Listener listener) {
    if (context == null)
        throw new NullPointerException();
    this.context = context;
    this.listener = listener
}