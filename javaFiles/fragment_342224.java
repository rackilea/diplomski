import java.util.List;

public enum InitialState implements LevelSettings {
    EMPTY {
        @Override
        public List<GameObject> startingObjects() {
            return readFromFile("empty.level");
        }
    },
    INTEGRATIONTEST {
        @Override
        public List<GameObject> startingObjects() {
            return readFromFile("integration_test.level");
        }
    },
    LEVEL_1 {
        @Override
        public List<GameObject> startingObjects() {
            return readFromFile("1.level");
        }
    },
    LEVEL_2 {
        @Override
        public List<GameObject> startingObjects() {
            return readFromFile("2.level");
        }
    };

    private static List<GameObject> readFromFile(String filename) {
        //Open file
        //Serialize its content in GameObjects
        //return them as a list
    }
}