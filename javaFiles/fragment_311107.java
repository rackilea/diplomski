int maxR = 0, maxC = 0;
for (String pair : pairs) {
    int r = ... // first part of the split
    int c = ... // second part of the split
    maxR = Math.max(maxR, r);
    maxC = Math.max(maxC, c);
}
boolean[][] myArray = new boolean[maxR][maxC];