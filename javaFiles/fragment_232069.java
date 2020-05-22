PutDataMapRequest request = PutDataMapRequest.create("/image");
Asset asset = createAssetFromBitmap(bitmap);
request.putAsset("profileImage", asset);
DataMap dataMap = request.getDataMap(); 
dataMap.putLong("timestamp", System.currentTimeMillis());
PutDataRequest dataRequest = request.asPutDataRequest();      
Wearable.DataApi.putDataItem(mGoogleApiClient, dataRequest);