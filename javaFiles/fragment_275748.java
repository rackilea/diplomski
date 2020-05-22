ArrayList<String> items = new ArrayList<String>();
AssetManager assetManager = getApplicationContext().getAssets();
for (String file : assetManager.list("")) {
    if (file.endsWith(".txt"))
        items.add(file);
}