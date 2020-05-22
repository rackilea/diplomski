checkAvailablePurchases(skuList, new OnResultInApp() {
                @Override
                public void onResult(ArrayList<AvailablePurchase> availablePurchaseArrayList) {
                    .. logic for showing view with available purchaseItem
                }
            });