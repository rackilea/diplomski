import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum InitialState implements LevelSettings {
    EMPTY {
        @Override
        public List<GameObject> startingObjects() {
            return Collections.emptyList();
        }
    },
    INTEGRATIONTEST {
        @Override
        public List<GameObject> startingObjects() {
            GameObject g1 = new GameObject("dummy 1");
            GameObject g2 = new GameObject("dummy 2");
            return Arrays.asList(g1, g2);
        }
    },
    LEVEL_1 {
        @Override
        public List<GameObject> startingObjects() {
            //read a config file to get the starting objects informations
            //or also hardcoded (not preferred)
        }
    },
    LEVEL_2 {
        @Override
        public List<GameObject> startingObjects() {
            //read a config file to get the starting objects
            //or also hardcoded (not preferred)
        }
    };
}