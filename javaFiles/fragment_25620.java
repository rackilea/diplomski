int[][] ret = new int[8][2];
int[] set = {-2, -1, 1, 2};
int i = 0;
for(int x : set)
    for(int y : set)
        if(Math.abs(x) != Math.abs(y)){
            ret[i][0] = x;
            ret[i][1] = y;
            i++;
        }