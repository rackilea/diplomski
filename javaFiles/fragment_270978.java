public static String downUp(int [][] test) {

    StringBuilder res = new StringBuilder();

    for (int c = 0; c < test[0].length; c++) {

        if (c % 2 == 0) {
            for (int r = 0; r < test.length; r++) {
                res.append(test[r][c]).append(" ");
            }

        } else {

            for (int r = test.length -1 ; r >=0 ; r--) {
                res.append(test[r][c]).append(" ");
            }
        }
    }
    return res.toString();
}