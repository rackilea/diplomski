int[][] bigMatrix = new int[9][9];
// initialize bigMatrix

int[][][] smallMatrices = new int[3][3][3];

for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
            smallMatrices[i][j][k] = bigMatrix[3*i+j][3*i+k];
        }
    }
}

// The submatrices are now in smallMatrices[i], 0 <= i < 3