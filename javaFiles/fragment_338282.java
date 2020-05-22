HashMap<Float, Integer> histogram = new HashMap<Float, Integer>();
for (int ip = 0; ip < IMAGE_PIXELS; ip++) {
  float brightness = // get the brightness for this pixel
  Integer count = histogram.get(brightness);
  if (count == null) {
    count = 1;
  }
  else {
    count++;
  }
  map.put(brightness, count);
}