static public <K> double calculateSimilarity(
        HashMap<K, Double> hashMap1, HashMap<K, Double> hashMap2, Class<K> clazz) {
      if (Comparable.class.isAssignableFrom(clazz)) {
        ...
      }
    }