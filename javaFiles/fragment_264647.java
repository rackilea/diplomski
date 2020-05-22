public class Game {

    private int level;

    public void update() {
        switch(level) {
            case 1:
                updateLevelOne();
                break;
            case 2:
                updateLevelTwo();
                break;
        }
    }

    public static void setLevel(int lv) {
        level = lv;
    }

    private updateLevelOne() {
        .....
    }

    private updateLevelTwo() {
        .....
    }
}