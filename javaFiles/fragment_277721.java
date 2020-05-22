for (Map<String,Number> source : sources) {
  for (String key : source.keySet() ) {
    if (!target.containsKey(key)) {
      target.put(key, 0);
    }
  }
}