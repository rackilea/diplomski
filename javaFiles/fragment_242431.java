public Heavy instance(Object key) {
  Heavy info = infoMap.get(key);
  if ( info == null ) {
    // It's OK to construct a Heavy that ends up not being used
    info = new Heavy(key);
    Heavy putByOtherThreadJustNow = infoMap.putIfAbsent(key, info);
    if ( putByOtherThreadJustNow != null ) {
      // Some other thread "won"
      info = putByOtherThreadJustNow;
    }
    else {
      // This thread was the winner
    }
  }
  return info;
}