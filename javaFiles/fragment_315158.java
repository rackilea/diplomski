private int getMinMax(int[][] table, boolean max){
    if(max) return max(table);
    else return min(table);
}

private int min(int[][] table){
    int tempMin = int[0][0];

    for(int i = 0; i < table.length; i++)
        for(int j = 1; j < table[i].length; j++)
            if(table[i][j] < tempMin) tempMin = table[i][j];

    return tempMin;

}

 private int max(int[][] table){
    int tempMax = int[0][0];

    for(int i = 0; i < table.length; i++)
        for(int j = 1; j < table[i].length; j++)
            if(table[i][j] > tempMax) tempMax = table[i][j];

    return tempMax;

}