public ToolsSource(Context context) throws IOException {
    int i;
    mCategory = new ToolsCategory[CATEGORIES.length];
    for (i = 0; i < CATEGORIES.length; i++) {
        mCategory[i] = new ToolsCategory(CATEGORIES[i], context);
    }
}