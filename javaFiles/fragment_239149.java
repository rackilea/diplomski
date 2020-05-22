public class ConnectFour implements Cloneable<ConnectFour> {
    private static final int NUM_ROWS = 6;
    private static final int NUM_COLS = 7;
    private int[][] state = new int[NUM_ROWS][NUM_COLS];
    // ...
    public ConnectFour clone() {
        int[][] stateCopy = new int[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++)
            for (int j = 0; j < NUM_COLS; j++)
                stateCopy[i][j] = this.state[i][j];
        ConnectFour cloned = new ConnectFour();
        cloned.setCurrentGameState(stateCopy);
        // copy other fields over to cloned
        return cloned;
    }
}