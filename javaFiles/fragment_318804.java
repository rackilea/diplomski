@Override public Collection<E> read(JsonReader in) throws IOException {
  if (in.peek() == JsonToken.NULL) {
    in.nextNull();
    return null;
  }

  Collection<E> collection = constructor.construct();
  in.beginArray();
  while (in.hasNext()) {
    E instance = elementTypeAdapter.read(in);
    collection.add(instance);
  }
  in.endArray();
  return collection;
}