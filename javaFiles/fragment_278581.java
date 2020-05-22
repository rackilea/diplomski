public boolean isTriDiagonal(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                int cell = matrix[x][y];

                if ((x==y) || (x-1==y) || (x+1==y)) {
                    if (cell == 0) {
                        return false;
                    }
                } else {
                    if (cell != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }