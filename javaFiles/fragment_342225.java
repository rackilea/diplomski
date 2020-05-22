import java.util.List;

public enum InitialState implements LevelSettings {
    EMPTY, INTEGRATIONTEST, LEVEL_1, LEVEL_2;

    @Override
    public List<GameObject> startingObjects() {
        return readFromFile(this.name() + ".level");
    }

    private static List<GameObject> readFromFile(String filename) {
        //Open file
        //Serialize its content in GameObjects
        //return them as a list
    }
}