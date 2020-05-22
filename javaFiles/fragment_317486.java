public class EightQueensSolver {

    final boolean[][] board ;
    final int[] queensPositions;

    public EightQueensSolver(int boardSize) {
        if(boardSize<4){
            throw new RuntimeException("Can not solve boards of size < 4");
        }
        board = new boolean[boardSize][boardSize];
        queensPositions = new int[boardSize];
    }

    boolean solve(){
        return solve(0);
    }

    boolean solve(int row){
        for(int col=0;col<board.length;col++){

            if(isSafe(row, col)){
                //place the queen for now in this spot
                board[row][col]=true;
                queensPositions[row] = col;
                //if we have finished the board, done.
                if(row==board.length-1) return true;
                //otherwise keep placing queens on next rows
                if(solve(row+1)){
                    //if placing the next queen will make the board solved, OK
                    return true;
                }else{
                    //otherwise backtrack and try other move
                    board[row][col]=false; 
                }
            }

        }
        return false;
    }

    boolean isSafe(int row,int col){
        //no need to test if on the same row, because we 
        //place a single queen on each row.
        //we only need to check if two queens are on 
        //same column or same diagonal
        for(int r=0;r<row;r++){
            for(int c=0;c<board.length;c++){
                if(board[r][c] && (c==col || Math.abs(c-col)==Math.abs(r-row))) 
                    return false;
            }
        }
        return true;
    }


    void printBoard(){
        System.out.println(Arrays.deepToString(board)
                .replace('[', '\n').replace("]", "")
                .replace("true", "Q").replace("false", " ")
        );
    }

    int getQueenColumnPosition(int row){
        return queensPositions[row];
    }
}