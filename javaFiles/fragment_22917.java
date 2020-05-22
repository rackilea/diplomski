public long getCollisions() {
  long counter = 0;
  for (int i = 0; i < buckets.length; i++) {
    if (buckets[i].length > 1) {
      counter += buckets[i].length; // 2 (or more) items collided in this bucket.
    }
  }
  return counter;
}