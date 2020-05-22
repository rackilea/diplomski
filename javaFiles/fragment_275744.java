Map<String, Storable<?>>map = new HashMap<>();

map.put(variableName1, new StorableInt(13));
map.put(variableName2, new StorableString("string2"));

<T extends Comparable<T>> int compare( String key, T val ) {
  return map.get( key ).compareTo( val );
}