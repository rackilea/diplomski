IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener 
    = new IabHelper.OnIabPurchaseFinishedListener() {
    public void onIabPurchaseFinished(IabResult result, 
                    Purchase purchase) 
    {
       if (result.isFailure()) {
          // Handle error
          return;
     }      
     else if (purchase.getSku().equals(ITEM_SKU)) {
         consumeItem();
        buyButton.setEnabled(false);
    }

   }
};