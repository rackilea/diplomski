private List<String> getNetworkOperator(final Context context) {
List<String> carrierNames = new ArrayList<>();
try {
    final String permission = Manifest.permission.READ_PHONE_STATE;
    if ( (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) && (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) ){
        final List<SubscriptionInfo> subscriptionInfos = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
        for (int i = 0; i < subscriptionInfos.size(); i++) {
            carrierNames.add(subscriptionInfos.get(i).getCarrierName().toString());
        }

    } else {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        // Get carrier name (Network Operator Name)
        carrierNames.add(telephonyManager.getNetworkOperatorName());

    }
} catch (Exception e) {
    e.printStackTrace();
}
return carrierNames;
}