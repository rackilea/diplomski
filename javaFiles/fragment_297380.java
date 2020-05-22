int[] pixels = new int[w * h]; // instead of int[][] pixels = new int[w][h];

// ...

for (int y = 0; y < h; y++) {
    for (int x = 0; x < w; x++) {

        // ...

        pixels[y * w + x] = share1(red, green, blue); // instead of pixels[x][y];
     }
 }