{
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                if (shape.isFilledAt(r, c) && space[r+row][c+col] != '.') {
                    return false; // eager to fail
                }
            }
        }
        return true; // slow to succeed: only if it never failed
   }