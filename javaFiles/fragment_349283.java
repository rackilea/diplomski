public class Entity {

    private UUID id;
    private Texture texture;
    private final Vector2 position = new Vector2();
    private final Vector2 velocity = new Vector2();

    public Entity(UUID id, Texture texture) {
        this.id = id;
        this.texture = texture;
    }

    //...
}