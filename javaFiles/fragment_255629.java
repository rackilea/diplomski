public void showList() { 

    View popupView = getLayoutInflater().inflate(R.layout.some_popup_view, null);

    PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    LinearLayout llPopup = (LinearLayout) popupView.findViewById(R.id.llPopup);

    PackageManager pm = getPackageManager();

    Intent intent = new Intent();

    // In my case, NfcAdapter.ACTION_NDEF_DISCOVERED was not returning anything
    //intent.setAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
    intent.setAction(NfcAdapter.ACTION_TECH_DISCOVERED);

    List<ResolveInfo> resolvedInfoList = pm.queryIntentActivities(intent, 0);

    String packageName = "";

    for(ResolveInfo resInfo : resolvedInfoList) {

        packageName = resInfo.activityInfo.applicationInfo.packageName;

        // Exclude `packageName` from the dialog/popup that you show
        if (!packageName.equals("com.example.my.package.name")) {

            TextView tv = new TextView(this);

            tv.setText(packageName);

            llPopup.addView(tv);
        }            

    }

    popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
}