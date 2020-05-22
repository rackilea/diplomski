protected static void verifyPurchase(String signedData, String signature) {
            ArrayList<VerifiedPurchase> purchases = BillingSecurity.verifyPurchase(signedData, signature);
            if(purchases != null && !purchases.isEmpty()){ // Check for NPE
                    latestPurchase = purchases.get(0);

                    confirmTransaction(new String[]{latestPurchase.notificationId});
            } else {
                    Log.d(TAG, "BillingHelper.verifyPurchase error. purchases was null");
            }

            if(mCompletedHandler != null){
                    mCompletedHandler.sendEmptyMessage(0);
            } else {
                    Log.e(TAG, "verifyPurchase error. Handler not instantiated. Have you called setCompletedHandler()?");
            }
    }