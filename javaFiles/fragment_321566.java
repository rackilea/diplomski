public boolean checkEqual(int[][] mat1,int[][] mat2){
    for(int i = 0;i<mat1.length;i++){
        for(int j=0;j<mat1.length;j++){
            if(mat1[i][j] != mat2[i][j]){
                return false;
            }
        }
    }
    return true;
}