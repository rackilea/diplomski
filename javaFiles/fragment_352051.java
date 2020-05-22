//Just to start it off.
int count_solutions(max_queens, max_bishops, a, b) {
    int[][] board= new int[a][b];
    return recurse(board, 0, a*b, max_queens, max_bishops, 0, 0);
}

//This is where the actual work is done.
//board is the board so far, represented by a two dimensional array where
//   -1 = Queen
//    0 = Empty
//    1 = Bishop
//i is the square we are currently on, and n is the total number of board.
//max_queens and max_bishops are the maximum allowed to place.
//queens and bishops are the number placed so far.
int recurse(board, i, n, max_queens, max_bishops, queens, bishops) {
    if(i == n || (max_queens == queens && max_bishops == bishops)) {
        //If we have placed all the pieces, it is time to check if it is a solution.
        //Return one if it is, otherwise zero.
        return (int) sheck_solution(board);
    }
    //We havent placed all the pieces yet. Time to do some recursion.
    //Get the two dimensional x and y coordinates for the one dimensional coordinate i.
    x = i / board.length;
    y = i % board.length);
    //Number of solutions = the sum of number of solutions for the alternatives.
    int solutions = 0;
    //Place a queen in the current spot.
    if(queens < max_queens) {
        board[x][y] = -1;
        solutions += recurse(board, i+1, n, max_queens, max_bishops, queens + 1, bishops);
    }
    //Place a bishop in the current spot.
    if(bishops < max_bishops) {
        board[x][y] = 1;
        solutions += recurse(board, i+1, n, max_queens, max_bishops, queens, bishops + 1);
    }
    //Place nothing in the current spot.
    board[x][y] = 0;
    solutions += recurse(board, i+1, n, max_queens, max_bishops, queens, bishops);
    return solutions;
}