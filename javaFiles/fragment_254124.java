public interface Drawable {
    void draw(Graphics g);
}

public class GameWorld {
    List<GameObject> gameObjects;
    List<GameObject> getGameObjects() {...}
}

public class GameAWorld extends GameWorld {...}

public class GameObject implements Drawable {
    // this could be abstract too. Whatever suits your needs.
    @Override
    public void draw(Graphics g) { ... }
}

//inside a renderer
List<GameObject> gameObjects = gameWorld.getGameObjects();
for (GameObject go : gameObjects)
    go.draw(g);