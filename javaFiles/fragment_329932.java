public Set<K> keySet() {
  Set<K> ks = keySet;
  return (ks != null ? ks : (keySet = new KeySet()));
}

private final class KeySet extends AbstractSet<K> {
  // minimal Set implementation to access the keys of the map
}