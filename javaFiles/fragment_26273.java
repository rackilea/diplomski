public class Board {
    static int boardSize = 8;
    ArrayList<Queen> queens = new ArrayList<Queen>();

    public Board(String s) {
        for (int i = 0; i < s.length(); i++) {
            queens.add(new Queen(i, s.charAt(i) - 49)); // you could implement
                                                        // base 16 here, for
                                                        // example, for a 15x15
                                                        // board
        }
    }

    public Board(Board b) { // duplicates the board, but keeps references to
                            // queens to conserve memory, only 96 total queens
                            // in existence through search!
        for (Queen q : b.queens) {
            queens.add(q);
        }
    }

    public boolean checkForImpact() {
        for (int i = 0; i < queens.size(); i++) {
            for (int j = i + 1; j < queens.size(); j++) {
                if (queens.get(i).checkKnight(queens.get(j))) { // just check
                                                                // for any
                                                                // queens
                                                                // intersecting,
                                                                // one hit is
                                                                // enough
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Board> getChildBoards() { // create child boards with a
                                                // single queen removed
        ArrayList<Board> boards = new ArrayList<Board>();
        for (int i = 0; i < queens.size(); i++) {
            boards.add(new Board(this));
        }
        int i = 0;
        for (Board b : boards) {
            b.queens.remove(i);
            i++;
        }
        return boards;
    }

    public String drawBoard() {
        String s = "";
        char[][] printableBoard = new char[boardSize][boardSize];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                printableBoard[i][j] = '_';
            }
        }
        for (Queen q : queens) {
            printableBoard[q.i][q.j] = 'Q';
        }
        s += "  A B C D E F G H\n";
        for (int i = 0; i < 8; i++) {
            s += (8 - i) + "|";
            for (int j = 0; j < boardSize; j++) {
                s += printableBoard[i][j];
                s += "|";
            }
            s += "\n";
        }
        return s;
    }
}