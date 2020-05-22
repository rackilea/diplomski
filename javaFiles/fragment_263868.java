public class Arbiter {
    private int player = 1;
    private String[][] gameValues = new String[3][3];

    public void setGame() {
        gameValues = new String[3][3];
    }

    public void reset() {
        setGame();
    }

    public boolean hasWinner() {
        if((gameValues[0][0].equals(gameValues[0][1])) && (gameValues[0][0].equals(gameValues[0][2]))) {
            return true;
        }
        return false;
    }

    public void setText(int x, int y) {
        if(player == 0) {
            gameValues[x][y] = "X";
            switchPlayer(1);
        } else {
            gameValues[x][y] = "O";
            switchPlayer(0);
        }
    }

    public String getBoardValue(int x, int y) {
        return gameValues[x][y];
    }

    public String[][] getBoardValues() {
        return gameValues;
    }

    private void switchPlayer(int newPlayer) {
        this.player = newPlayer;
    }
}