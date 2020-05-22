public static boolean columnValuesIncrease(int[][] t) {
    for(int i = 0 ; i < t.length - 1 ; i++) 
        for(int j = 0 ; j < Math.min(t[i].length, t[i+1].length) ; j++) 
            if(t[i][j] > t[i+1][j])
                return false;
    return true;
}