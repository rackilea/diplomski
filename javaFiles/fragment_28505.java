Stack stack = new Stack();
AssetManager assets = this.getAssets();
String[] assetLocations = assets.list();

for (int i=0;i<assetLocations.length;i++){
    byte[] asset = loadAssetFromStream(assetLocations[i]); // you need to write this
    stack.push(asset);
}