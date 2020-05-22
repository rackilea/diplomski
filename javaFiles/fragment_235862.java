class Util {
  static <T> TypeToken<List<T>> listType() {
    return new TypeToken<List<T>>() {};
  }
}

TypeToken<List<String>> stringListType = Util.<String>listType();