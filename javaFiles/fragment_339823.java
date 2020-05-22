IabHelper.QueryInventoryFinishedListener mGotInventoryListener
   = new IabHelper.QueryInventoryFinishedListener() {
   public void onQueryInventoryFinished(IabResult result,
      Inventory inventory) {

      if (result.isFailure()) {
        // handle error here
      }
      else {
        // does the user have the premium upgrade?
        mIsPremium = inventory.hasPurchase(SKU_PREMIUM);
        // update UI accordingly
      }
   }
};