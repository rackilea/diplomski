int a = (pixel >>> 24) & 0xFF;
int r = (pixel >>> 16) & 0xFF;
int g = (pixel >>>  8) & 0xFF;
int b = (pixel >>>  0) & 0xFF;

int filteredPixel = (a << 24) | (b << 16) | (g << 8) || (r << 0);