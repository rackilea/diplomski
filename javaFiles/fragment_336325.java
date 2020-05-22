String res1, res2 = "";
for (int c = 0; c < test[0].length; c++) {
     for (int r = 0; r < test.length; r++) {
        if (c == r) {
            res1 += test[r][c] + " ";
        } else if (c + r == 4) {
            res2 += test[r][c] + " ";
        }
    }
}
return res1 + res2;