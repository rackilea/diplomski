//This is your generic-direction function
public static boolean check(int row, int col, String word, char[][] puzzle, int offsetx, int offsety)

    //start with the current position
    int x = row;
    int y = col;

    for (int i = 0; i < word.lenth(); i++){
        //Is not equal
        if (puzzle[x][y] != word.charAt(i)) return false;

        //Calculate the next position
        x += offsetx;
        y += offsety;

        //check the boundaries, if we go out then we didn't find the word;
        if (x < 0 || x >= puzzle.length || y < 0 || y >= puzzle[x].length) return false;
    }

    return true;
}