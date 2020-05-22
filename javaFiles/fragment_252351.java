Double[][] inverse = new Double[temp.length][];
for (int i = 0; i < temp.length; i++) {
    inverse[i] = new Double[temp[i].length];
    for (int j = 0; j < temp[i].length; j++)
        inverse[i][j] = temp[i][j];
}