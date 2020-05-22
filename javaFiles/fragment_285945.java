for(int i = 0; i < gridwidth; i++){
    for(int j = 0; j < gridheight; j++){
        int neighbors = 0;
        // find the proper boundaries
        int minI = Math.max(0, i - 1);
        int maxI = Math.min(gridwidth, i + 2)
        int minJ = Math.max(0, j - 1);
        int maxJ = Math.min(gridheight, j + 2)

        for (int i2 = minI; i2 < maxI; i2++) {
           for (int j2 = minJ; j2 < maxJ; j2++) {
              if (i2 != i || j2 != j) {
                 if (pixels[i2][j2] == 1) {
                    neighbors++;
                 }
              }
           }
        }

        if (neighbors == 2 || neighbors == 3) {
           cachedPixels[i][j] = 1;
        } else {
           cachedPixels[i][j] = 0; // probably not even necessary as 0 is default value
        }
    }   
}