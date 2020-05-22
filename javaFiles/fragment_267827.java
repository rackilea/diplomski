PurchaseCallback mCallback = null;

mPurchaseFinishedListener = ... etc. etc.
.
.
.
   if (mCallback != null) {
       mCallback.setPurchaseResult(0);
   }
.
.
.

@Override
public int requestIabPurchase(int product, PurchaseCallback callback) {
    mCallback = callback;  // save this for later

    iAbStartup();

    return 0;
}