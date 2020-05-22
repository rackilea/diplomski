for (int i = 0; i < assetList.size(); i++) {
    HashMap<String, String> asset = assetList.get(i);
    if (asset.get(KEY_CODE).equals(scanAsset)){
        asset.put(KEY_CHECKED, "Checked");
        Log.i("Asset code is ", scanAsset);
    }
}
adapter.notifyDataSetChanged();