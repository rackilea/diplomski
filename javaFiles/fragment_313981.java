AssetManager assetManager = this.getAssets();
Bitmap[] yourImages = new Bitmap[] {
    BitmapFactory.decodeStream(assetMgr.open("firstimage.png"));
    BitmapFactory.decodeStream(assetMgr.open("secondimage.png"));
    BitmapFactory.decodeStream(assetMgr.open("thirdimage.png"));
};