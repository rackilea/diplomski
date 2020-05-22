public class EightQueensSolver {

    final int[] queensPositions;

    public EightQueensSolver(int boardSize) {
        if(boardSize<4){
            throw new RuntimeException("Can not solve boards of size < 4");
        }
        queensPositions = new int[boardSize];
        Arrays.fill(queensPositions, -1);
    }

    boolean solve(){
        return solve(0);
    }

    boolean solve(int row){
        for(int col=0;col<queensPositions.length;col++){

            if(isSafe(row, col)){
                //place the queen for now in this spot
                queensPositions[row] = col;
                //if we have finished the board, done.
                if(row==queensPositions.length-1) return true;
                //otherwise keep placing queens on next rows
                if(solve(row+1)){
                    //if placing the next queen will make the board solved, OK
                    return true;
                }else{
                    //otherwise backtrack and try other move
                    queensPositions[row]=-1; 
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
            int c = queensPositions[r];
            if(c==col || Math.abs(c-col)==Math.abs(r-row)) 
                return false;
        }
        return true;
    }


    void printBoard(){
        for(int row=0;row<queensPositions.length;row++){
            for(int col=0;col<queensPositions.length;col++){
                if(queensPositions[row]==col) System.out.print("Q,");
                else System.out.print(" ,");
            }
            System.out.println();
        }
    }

    int getQueenColumnPosition(int row){
        return queensPositions[row];
    }
}