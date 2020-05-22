@GwtCompatible(serializable = true)
public static <E> ArrayList<E> More ...newArrayList(Iterable<? extends E> elements) {
  checkNotNull(elements); // for GWT
  // Let ArrayList's sizing logic work, if possible
  if (elements instanceof Collection) {
    @SuppressWarnings("unchecked")
    Collection<? extends E> collection = (Collection<? extends E>) elements;
    return new ArrayList<E>(collection);
  } else {
    return newArrayList(elements.iterator());
  }
}