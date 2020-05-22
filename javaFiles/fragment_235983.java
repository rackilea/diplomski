mHelper = new IabHelper(this, base64EncodedPublicKey);

mHelper.enableDebugLogging(true);

mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
public void onIabSetupFinished(IabResult result) {

if (!result.isSuccess()) {
return;
}

if (mHelper == null) return;
List<String> st = new ArrayList<String>();
st.add(ITEM_SKU);
mHelper.queryInventoryAsync(true,st,mGotInventoryListener);
}
});