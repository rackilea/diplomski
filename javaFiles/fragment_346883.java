public void buyProduct() {
    PendingIntent buyIntent = ... // create your intent here
    IntentSender sender = buyIntent.getIntentSender();
    try {
        startIntentSenderForResult(sender, REQ_BUY_PRODUCT, new Intent(), 0, 0, 0);
    } catch (SendIntentException e) {
        Log.e(TAG, "", e);
    }
}