import java.util.ArrayList;

public class Test {
    static String[] boards = { "24683175", "17468253", "17582463", "41582736",
            "51842736", "31758246", "51468273", "71386425", "51863724",
            "57142863", "63184275", "53172864" }; // all 12 solutions for the 8
                                                    // queens problem
    static ArrayList<Board> boardObjects = new ArrayList<Board>();

    public static void main(String[] args) {
        for (String queens : boards) { // create starter boards
            boardObjects.add(new Board(queens));
        }

        int i;
        ArrayList<Board> foundBoards = null;
        for (i = 8; i > 0; i--) {
            ArrayList<Board> newBoards = new ArrayList<Board>();
            foundBoards = new ArrayList<Board>();
            for (Board b : boardObjects) {
                if (b.checkForImpact()) { // if any queen intercepts we get
                                            // children
                    ArrayList<Board> boardsToBeAdded = b.getChildBoards(); // pass
                                                                            // all
                                                                            // permutations
                                                                            // of
                                                                            // queens
                                                                            // once
                                                                            // removed
                    for (Board bo : boardsToBeAdded) {
                        newBoards.add(bo); // add it in to the next list
                    }
                } else {
                    foundBoards.add(b); // if we have no impact, we have a
                                        // solution
                }
            }
            if (!foundBoards.isEmpty())
                break;
            boardObjects.clear();
            boardObjects = newBoards;
        }
        System.out.println("The maximum number of super-queens is: " + i);
        ArrayList<String> winningCombinations = new ArrayList<String>();
        for (Board board : foundBoards) {
            String createdBoard = board.drawBoard();
            boolean found = false;
            for (String storedBoard : winningCombinations) {
                if (storedBoard.equals(createdBoard))
                    found = true;
            }
            if (!found)
                winningCombinations.add(createdBoard);
        }
        for (String board : winningCombinations) {
            System.out.println(board);
        }
    }
}