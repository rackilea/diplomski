List<Integer> maxIndexes = new ArrayList<>();
for ( int i = 0; i < posNum; i++) {
    if ( possibilitynum[i] > max) {
        max = possibilitynum[i];
        maxIndexes.clear();
        maxIndexes.add(i);
    } else if (possibilitynum[i] == max) {
        maxIndexes.add(i);
    }
}
int count = maxIndexes.size(); // <-- for example