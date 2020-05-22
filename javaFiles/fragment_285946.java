cachedPixels[i][j] = 0; // Default value - death.
if (neighbors == 3) {
   cachedPixels[i][j] = 1;
} else if (thisCell == 1 && neighbors == 2) {
   cachedPixels[i][j] = 1;
}