int width = img.getWidth();
int height = img.getHeight();

int input[][] = img.getPixels(); // or whatever api you use
int output[][] = new int[height][width];
int kernel[][] = {
  {-1,-1,-1},
  {-1,8,-1},
  {-1,-1,-1}
};


for (int y = 0; y < height; y++) {
  for (int x = 0; x < width; x++) {
    int accumulator = 0;
    for (int v = 0; v < 3; v++) {
      for (int w = 0; w < 3; w++) {
        int sy = y + v - 1;
        int sx = x + w - 1;
        if (sy >= 0 && sy < height && sx >= 0 && sx < width)) {
          accumulator += input[sy][sx] * kernel[v][w];
        }
      }
    }
    output[sy][sx] = accumulator;
  }
}