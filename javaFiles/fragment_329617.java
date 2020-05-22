class EnumEnumerator<T extends Enum<T>> implements Iterable<T> {
    private final Class<T> enumClass;

    public EnumEnumerator(Class<T> enumClass) {
      this.enumClass = enumClass;
    }

    public Iterator<T> iterator() {
      T[] values = enumClass.getEnumConstants();
      return Arrays.asList(values).iterator();
    }
  }