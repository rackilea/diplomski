class Storable<T extends Comparable<T>> {
  private final T value;
  Storable(T value) {
    this.value = value;
  }
  int compareTo(Object other) {
    if ( value.getClass().equals(other.getClass()) ) {
      return value.compareTo( (T) other );
    }
    return -1;
  }
}