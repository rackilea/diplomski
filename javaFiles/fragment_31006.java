If you have used the android.test.purchased then one way to get rid of the error is to do the following:-

 1. Edit Security.java and change the "return false" line in the
    verifyPurchase to "return true" - this is temporary, we'll be
    putting it back in a minute.
 2. In your QueryInventoryFinishedListener, after the "if
    (result.isFailure()) {...}" lines add the following to consume and
    get rid of your never ending android.test.purchased item:-

    if (inventory.hasPurchase(SKU_ANDROID_TEST_PURCHASE_GOOD)) {
    mHelper.consumeAsync(inventory.getPurchase(SKU_ANDROID_TEST_PURCHASE_GOOD),null);
    }
 3. Run your app so the consunmeAsync happens, this gets rid of the
    "android.test.purchased" item on the server.
 4. Remove the consumeAsync code (or comment it out). Back in the
    Security.java, change the "return true" back to "return false".