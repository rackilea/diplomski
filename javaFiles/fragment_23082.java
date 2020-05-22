SubscriptionManager subscriptionManager = (SubscriptionManager) getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
    List<String> carrierNames = new ArrayList<>();
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
        List<SubscriptionInfo> subscriptionInfos = subscriptionManager.getActiveSubscriptionInfoList();
        for (int i = 0; i < subscriptionInfos.size(); i++) {
            carrierNames.add(subscriptionInfos.get(i).getCarrierName().toString());
        }
    }