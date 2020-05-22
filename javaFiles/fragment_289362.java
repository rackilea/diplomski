purchaseItem(googleInAppId, new OnResultPurchase() {
            @Override
            public void onSuccess(PurchaseResponseBean purchaseResponseBean, String inAppPurchaseData) {
               // your stuff 
            }

            @Override
            public void onError() {
                showToast(R.string.something_went_wrong);
            }
        });