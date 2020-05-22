public static void main(String[] args) {

    final int [][] test = { {1, 6, 11, 16, 21}, 
            {2, 7, 12, 17, 22}, 
            {3, 8, 13, 18, 23}, 
            {4, 9, 14, 19, 24}, 
            {5, 10, 15, 20, 25} };
    System.out.println(downUp(test));
}

public static String downUp(int [][] test) {
    String res = "";
    for (int c = 0; c < test[0].length; c++) {

        if (c % 2 == 0) {
            for (int r = 0; r < test.length; r++) {
                res += test[r][c] + " ";
            }

        } else {

            for (int r = test.length -1 ; r >=0 ; r--) {
                res += test[r][c] + " ";
            }
        }
    }
    return res;
}