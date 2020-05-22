public class State {
    int[][] Board = new int[6][6];
    Block[] blocks;
    Block core = new Block();
    State pre;

    public void initialiseBlocks(int n) {
        // Initialise the blocks array.
        blocks = new Block[5];

        // Instantiate Block instances in the array.
        for (int i = 0; i < n; ++i) {
            blocks[i] = new Block();
        }
    }
}