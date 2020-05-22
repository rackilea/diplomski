// Listener that's called when we finish querying the items and subscriptions we own
private QueryInventoryFinishedListener mGotInventoryListener = new QueryInventoryFinishedListener() {
    public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
        Logging.d(TAG, "Query inventory finished.");

        // Have we been disposed of in the meantime? If so, quit.
        if (mHelper == null) return;

        // Is it a failure?
        if (result.isFailure()) {
            complain(context.getResources().getString(R.string.subscription_error_subscription_error_to_query_inventory) + " " + result);
            return;
        }

        Logging.d(TAG, "Query inventory was successful.");

        // First find out which subscription is auto renewing
        Purchase subscriptionMonthly = inventory.getPurchase(SKU_SUBSRIPTION_MONTHLY);

        // The user is subscribed if either subscription exists, even if neither is auto
        // renewing
        mSubscribedToFreeAds = (subscriptionMonthly != null);
        Logging.d(TAG, "User " + (mSubscribedToFreeAds ? "HAS" : "DOES NOT HAVE")
                + " monthly subscription.");
        if (mSubscribedToFreeAds) {
            putPurchase(subscriptionMonthly);//save purchase
            isSubscribed = true;
        } else {
            clearPurchase();
            isSubscribed = false;
        }

        updateUi();
        setWaitScreen(false);
        Logging.d(TAG, "Initial inventory query finished; enabling main UI.");
    }
};