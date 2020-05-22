int firstarray[][] = {{1, 2, -2, 0}, {-3, 4, 7, 2}, {6, 0, 3, 1}};
int secondarray[][] = {{-1, 3}, {0, 9}, {1, -11}, {4, -5}};

/* Create another 2d array to store the result using the original arrays' lengths on row and column respectively. */
int [][] result = new int[firstarray.length][secondarray[0].length];

/* Loop through each and get product, then sum up and store the value */
for (int i = 0; i < firstarray.length; i++) { 
    for (int j = 0; j < secondarray[0].length; j++) { 
        for (int k = 0; k < firstarray[0].length; k++) { 
            result[i][j] += firstarray[i][k] * secondarray[k][j];
        }
    }
}
/* Show the result */
display(result);