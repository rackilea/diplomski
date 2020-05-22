for (x = -R; x <= R; x++)
  for (y = -R; y <= R; y++) {
    double r = Math.sqrt(x * x + y * y);
    double inv_rad = r <= R ? 1 / r : 0; // truncate outside radius R
    map[yc + y][xc + x] = 1 - inv_rad;
  }