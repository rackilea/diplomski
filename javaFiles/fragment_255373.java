for (int x = 0; x < 3; ++x) {
    for (int y = 0; y < 3; ++y) {

        if(firstMatrix[x][y] < 0)
            secondMatrix[x][y] = "NEGATIVE";
        else
            secondMatrix[x][y] = "POSITIVE";            
    }
 }