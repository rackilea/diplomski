class Game {

    public static void main(String[] args) {
        // Create the Roll obj
        Roll myRoll = new Roll();
        // Initialize the other objs with myRoll
        Board board = new Board(myRoll);
        Player player = new Player(myRoll);
        // Do your comparison
        int b = board.getRoll();
        int p = player.getRoll();
        // EDIT: get a new value
        myRoll.level();
        // Do your comparison once more
        b = board.getRoll();
        p = player.getRoll();

    }

    class Board {
        Roll r;
        Board(Roll roll) {
            this.r = roll;
        }
        public int getRoll() {
            return r.getR();
        }
    }

    class Player {
        Roll r;
        Player(Roll roll) {
            this.r = roll;
        }
        public int getRoll() {
            return r.getR();
        }
    }
}