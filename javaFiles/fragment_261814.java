public static <T> Collection<Collection<T>> split(Collection<T> bigCollection, int maxBatchSize) {
    Collection<Collection<T>> result = new ArrayList<Collection<T>>();

    ArrayList<T> currentBatch = null;
    for (T t : bigCollection) {
      if (currentBatch == null) {
        currentBatch = new ArrayList<T>();
      } else if (currentBatch.size() >= maxBatchSize) {
        result.add(currentBatch);
        currentBatch = new ArrayList<T>();
      }

      currentBatch.add(t);
    }

    if (currentBatch != null) {
      result.add(currentBatch);
    }

    return result;
  }