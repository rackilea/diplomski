int count = 0;
for ( int i = 0; i < posNum; i++) {
    if ( possibilitynum[i] > max) {
        max = possibilitynum[i];
        count = 1;
    } else if (possibilitynum[i] == max) {
        count++;
    }
}