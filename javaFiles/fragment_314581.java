public class IndexMap<T> {
  private List<T> elements = new ArrayList<>();
  private Map<T, Integer> indices = new HashMap<>();

  public int add(T element) {
    int index = elements.size();
    elements.add(element);
    indices.put(element, index);
    return index;
  }

  public int getIndex(T element) {
    Integer index = indices.get(element);
    return index == null ? -1 : index;
  }

  public T getElement(int index) {
    return elements.get(index);
  }