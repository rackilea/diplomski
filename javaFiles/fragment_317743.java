public static final int MAX_COLOR_COUNT = 65536;

/**
 * @param pixels rgb 888
 * @param palette int[256]
 * @return indices of colors in palette
 */
private int[][][] createPalette(int[] pixels, int[] palette) {

  final int[] histogram = new int[MAX_COLOR_COUNT]; // pixel count histogram
  final int[] indices = new int[MAX_COLOR_COUNT]; // here index is color value

  for (int i = 0; i < MAX_COLOR_COUNT; i++) {
    indices[i] = i;    
  }

  // creating histogram
  for (int color : pixels) {
    //                   0001 1111             0111 1110 0000         1111 1000 0000 0000
    color = ((color >> 3) & 0x1F) | ((color >> 5) & 0x7E0) | ((color >> 8) & 0xF800);
    if (histogram[color] < Integer.MAX_VALUE) { // picture must be really big
      histogram[color]++;
    }
  }

  // removing zeros
  int j = 0;
  for (int i = 0; i < MAX_COLOR_COUNT; i++) {
    histogram[j] = histogram[i];
    indices[j] = indices[i];
    if (histogram[j] != 0) {
      j++;
    }
  }
  final int histograms = j;

  // bubble sort
  for (int i = 1; i != 0; ) {
    i = 0;
    for (int x = 0, y = 1; y < histograms; x++, y++) {
      if (histogram[x] < histogram[y]) {
        i = histogram[x];
        histogram[x] = histogram[y];
        histogram[y] = i;
        i = indices[x];
        indices[x] = indices[y];
        indices[y] = i;
        i = 1;
      }
    }
  }

  final int[][][] colorMap = new int[32][64][32];

  int colorTableIndex = 0, x = 0;
  for (; x < histograms; x++) { // main colors
    final int color = indices[x];
    // 1f (16) = 0001 1111 (2)
    // 3f (16) = 0011 1111 (2)
    // (1111 1)(111 111)(1 1111)
    final int b = color & 0x1f;
    final int g = (color >> 5) & 0x3f;
    final int r = (color >> 11) & 0x1f;

    // skip if similar color already in palette[]
    int a = 0, i = 0;
    for (; i < colorTableIndex; i++) {
      final byte tempB = (byte) ((palette[i] >> 3) & 0x1f);
      final byte tempG = (byte) ((palette[i] >> 10) & 0x3f);
      final byte tempR = (byte) ((palette[i] >> 19) & 0x1f);

      // if difference between two colors is pretty small
      // taxicab distance
      int difference = tempB - b;
      if (difference < 0) {
        difference = -difference;
      }
      a = difference;
      difference = tempG - g;
      if (difference < 0) {
        difference = -difference;
      }
      a += difference;
      difference = tempR - r;
      if (difference < 0) {
        difference = -difference;
      }
      a += difference;
      if (a <= 2) { // smaller than 16/8
        a = 1;
        break;
      }
      a = 0;
    }

    if (a != 0) {
      colorMap[r][g][b] = i; // map to existing color
    } else {
      colorMap[r][g][b] = colorTableIndex; // map to new index

      // 1111 1000 1111 1100 1111 1000
      palette[colorTableIndex] = b << 3 | (g << 10) | (r << 19); // fill this index with new color
      colorTableIndex++;
      if (colorTableIndex >= 256/*palette.length*/) {
        x++;
        break;
      }
    }
  }   // colorTableIndex = new color table size

  for (; x < histograms; x++) { // minor colors

    final int color = indices[x];

    final int b = color & 0x1f;
    final int g = (color >> 5) & 0x3f;
    final int r = (color >> 11) & 0x1f;

    // find closest color
    int minDistance = -1;
    int colorIndex = 0;
    for (int a, i = 0; i < colorTableIndex; i++) {
      final byte tempB = (byte) ((palette[i] >> 3) & 0x1f);
      final byte tempG = (byte) ((palette[i] >> 10) & 0x3f);
      final byte tempR = (byte) ((palette[i] >> 19) & 0x1f);

      int difference = tempB - b;
      if (difference < 0) {
        difference = -difference;
      }
      a = difference;
      difference = tempG - g;
      if (difference < 0) {
        difference = -difference;
      }
      a += difference;
      difference = tempR - r;
      if (difference < 0) {
        difference = -difference;
      }
      a += difference;
      if ((minDistance < 0) || (minDistance > a)) {
        minDistance = a;
        colorIndex = i;
      }
    }
    colorMap[r][g][b] = colorIndex;
  }

  return colorMap;
}

private byte[] map(int[] pixels, int[][][] colorMap) {
  final int pixelsLength = pixels.length;

  final byte[] mapped = new byte[pixelsLength];
  for (int i = 0; i < pixelsLength; i++) {
    final int color =
        ((pixels[i] >> 3) & 0x1F) | ((pixels[i] >> 5) & 0x7E0) | ((pixels[i] >> 8) & 0xF800);

    final int b = color & 0x1f;
    final int g = (color >> 5) & 0x3f;
    final int r = (color >> 11) & 0x1f;

    mapped[i] = (byte) colorMap[r][g][b];
  }
  return mapped;
}