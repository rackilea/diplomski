count = 1     // We just placed one counter
row = r-1; col = c-1
while ( (row >= 0) and (col >= 0) and 
        (board_matrix[row][col] == player) )
    count += 1

row = r+1; col = c+1
while ( (row < board_size) and (col < board_size) and 
        (board_matrix[row][col] == player) )
    count += 1

// Note: gomoku rules require exactly 5 in a row;
//   if you're playing with a"at least 5", then adjust this to >=
if (count == win_length) {
    // Process the win
}