public class Elevator {

    int actualLevel = 0;

    public void goTo(int level) {
        if (level < -2 || level > 10) {
            System.out.println("Invalid level!. Levels range is -2 to 10.");
            return;
        }

        if (level > actualLevel) {
            System.out.println("Elevator going up to floor " + level);
            this.actualLevel = level;
        } else if (level < actualLevel) {
            System.out.println("Elevator going  down to floor " + level);
            this.actualLevel = level;
        } else if (level == actualLevel) {
            System.out.println("Elevator already on the floor " + level);
        }
    }

    public int where() {
        return this.actualLevel;
    }

}