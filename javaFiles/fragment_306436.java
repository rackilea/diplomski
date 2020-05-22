public void onIabSetupFinished(IabResult result) {    
        if (!result.isSuccess()) {
           return;
        }
        if (QueryInventoryListner.mHelper == null){
           return;
        }
        try {
           mHelper.queryInventoryAsync(mGotInventoryListener);
        } catch (IabAsyncInProgressException e) {
           complain(context.getResources().getString(R.string.subscription_error_subscription_error_to_query_inventory_another_async));
        }
    }