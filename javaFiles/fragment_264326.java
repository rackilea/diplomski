private World world;
private WorldContactListener worldContactListener;

public PlayScreen(main game) {
    ...
    world = new World(new Vector2(0,-10), true);
    worldContactListener = new WorldContactListener();
    world.setContactListener(worldContactListener);
    ...
}