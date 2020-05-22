static final Map<Integer, Color> colorMap;
static {
    Map<Integer, Color> colorMapData = new HashMap<Integer, Color>();
    Color blue = SWTResourceManager.getColor(SWT.COLOR_BLUE);
    Color green = SWTResourceManager.getColor(SWT.COLOR_GREEN);
    colorMapData.put(1, blue);
    colorMapData.put(2, blue);
    colorMapData.put(3, green);
    colorMapData.put(4, green);
    colorMapData.put(5, blue);
    //...
    //this makes colorMap truly constant and its values cannot be modified
    colorMap = Collections.unmodifiableMap(colorMapData);
}