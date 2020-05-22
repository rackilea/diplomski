private Map<Integer, Integer> supportedReolutions;
    private String graphicFolder;

    supportedReolutions = new HashMap<Integer, Integer>();
    supportedReolutions.put(1024, 768);
    supportedReolutions.put(1080, 1920);
    supportedReolutions.put(1200, 1920);
    supportedReolutions.put(2048, 1536);
    supportedReolutions.put(480, 800);
    supportedReolutions.put(640, 1136);
    graphicFolder = "1080x1920";

/**
 * Chose the folder with best graphic for current device
 */
private void setCurrentResolutionFolder() {
    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();
    if (supportedReolutions.containsKey(width)) {
        if (supportedReolutions.get(width) == height) {
            graphicFolder = String.valueOf(width) + "x"
                    + String.valueOf(height);
        }
    }
}