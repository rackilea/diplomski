public class WorldRenderer {
    private final Map map;
    private final Camera camera;
    private final List<LightSource> lightSources;

    public WorldRenderer(Map map, Camera camera, List<LightSource> sources) {
        this.map = map;
        this.camera = camera;
        this.lightSources = sources;
    }

    public void render() {
        Viewport viewport = camera.getViewport();
        Map submap = map.getVisibleMapFor(viewport);
        Scene litScene = applyLighting(submap); // using lightSources
        renderScene(litScene);
    }

    private void renderScene(Scene scene) {
        ...
    }
}