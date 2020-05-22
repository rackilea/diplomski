import java.util.List;

public class BoardState {
    private final List<GameObject> gameObjects;

    public BoardState(LevelSettings settings) {
        this.gameObjects = settings.startingObjects();
    }
}