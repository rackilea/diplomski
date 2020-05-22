int total = 0;
int numberOfElements = 0;
for (int[][] n : v) {
    for (int[] b : n) {
        for (int c : b) {
            numberOfElements++;
            total += c;
        }
    }
}