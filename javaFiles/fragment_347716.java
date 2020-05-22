int sum = 0;
for(int i = 0 ; i < a.length ; ++i) {
    for(int j = i + 1 ; j < a[i].length ; ++j) {
        sum += a[i][j];
    }
}