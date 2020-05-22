byte[] argb = ...;
byte[] rgb = new byte[(argb.length / 4) * 3];

int index = rgb.length - 1;

for (int i = argb - 1; i >= 0; i -= 4) {
  rgb[index--] = argb[i];
  rgb[index--] = argb[i - 1];
  rgb[index--] = argb[i - 2];
}