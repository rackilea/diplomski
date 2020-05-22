public ToolsCategory(String name, Context context) throws IOException {
    this.context = context;
    AssetManager assetManager = context.getAssets();
    categoryName = name;
    mTools = new Tool[TOOLS_PER_CATEGORY];
    assignValues(categoryName, assetManager);
}