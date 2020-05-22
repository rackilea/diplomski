AssetManager assetManager = getAssets();
InputStream stream;

try {

            stream = assetManager.open(imagePathList.get(i));

            Bitmap bitmap = BitmapFactory.decodeStream(stream);

            if (bitmap != null)
                imageItems.add(new ImageItem(bitmap, "Image#" + i));

        } catch (IOException ex) {

            return null;

}