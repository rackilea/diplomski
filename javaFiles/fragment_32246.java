public class WeirdEnum extends AbstractList<WeirdEnum> {

  private static List<WeirdEnum> underlyingList = new ArrayList<>();

  @Override
  public WeirdEnum get(int index) { return underlyingList.get(index); }

  @Override
  public int size() { return underlyingList.size(); }

  static <T extends List<T>> List<T> getAList() {
    return Collections.emptyList();
  }

  public WeirdEnum() {
    underlyingList.add(this); // Sufficient for our example but not a good idea due to concurrency concerns.
  }

  static List<WeirdEnum> foo = WeirdEnum.getAList();
}