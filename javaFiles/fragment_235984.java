IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
public void onQueryInventoryFinished(IabResult result, Inventory inventory) {

if (mHelper == null) return;

if (result.isFailure()) {
return;
}

if(inventory.hasPurchase(ITEM_SKU)) {
Intent intent = null;
intent = new Intent(getActivity(), Ce.class); 
startActivity(intent);
}
}
};