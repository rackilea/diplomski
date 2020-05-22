char[] str = "acxrabdz".toCharArray();
int[] pos = {1, 2, 1, 3, 4, 1, 2, 1};
int[] len = new int[pos.length];
// Count how many characters are in each group
for (int n : pos) {
    len[n-1]++;
}
// Pre-allocate space for each group of characters
char[][] tmp = new char[pos.length][];
for (int i = 0 ; i != pos.length ; i++) {
    if (len[i] != 0) {
        tmp[i] = new char[len[i]];
    }
}
// Scatter characters from the string into their group arrays
int[] tpos = new int[pos.length];
for (int i = 0 ; i != pos.length ; i++) {
    int p = pos[i]-1;
    tmp[p][tpos[p]++] = str[i];
}
// Sort each individual group in ascending order
for (int i = 0 ; i != pos.length ; i++) {
    if (tmp[i] != null) {
        Arrays.sort(tmp[i]);
    }
}
// Put characters back into the string starting at the back
for (int i = 0 ; i != pos.length ; i++) {
    int p = pos[i]-1;
    str[i] = tmp[p][--tpos[p]];
}