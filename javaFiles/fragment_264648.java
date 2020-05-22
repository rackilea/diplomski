public class Game {

    private Level[] levels;
    private int currentLevel;

    public Game() {
        levels = new Level[2]
        levels[0] = new Level();
        levels[1] = new Level();
        currentLevel = 0;
    }

    public void update() {
        levels[currentLevel].update();
    }

    public static void setLevel(int newLevel) {
        currentLevel = newLevel;
    }
}

public class Level {

    public Level() {

    }

    public void update() {

    }
}