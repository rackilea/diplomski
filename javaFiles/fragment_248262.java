public static String toString(int[][] array) {
    String res = "{";
    for (int i = 0; i < array.length; i++) {
        if (i > 0)
            res += ",";
        res += "{";
        for (int j = 0; j <array[i].length; j++) {
             if (j> 0)
                res += ",";
            res += array[i][j];
        }
      res += "}";

    }
    res += "}";
    return res;
}