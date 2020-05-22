private void handleSendText(Intent intent) {
    String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);

    if (sharedText != null) {
        ReactContext context = NavigationApplication.instance.getReactGateway().getReactContext();

        if (context != null) {
            WritableMap params = Arguments.createMap();
            params.putString("event", sharedText);

            context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("share", params);
        }
    }
}