public static boolean oddRow(int[][] a, int r, int c) {

        //checking if we checked all rows
        if (r > 4) {
            return true;
        }
        //checking if all columns in row were checked and moving to r+2 row
        if (c > 3) {
            return oddRow(a, r + 2, 0);
        }
        //checking if current value is odd - if yes, keep checking the rest / if not, return false
        return (a[r][c] % 2 == 0) ? oddRow(a, r, c + 1) : false;

    }