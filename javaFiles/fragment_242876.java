int i = 2
for (int col = 0; col < acols; col++){
    for (int row = 0; row < arows;row++){
        cells[row][col] = Integer.parseInt(s[i]);
        i++;
    }
}