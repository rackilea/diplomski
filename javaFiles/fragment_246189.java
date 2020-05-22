public class CustomListAssert<E> extends ListAssert<E> {
  public static <E> CustomListAssert<E> assertThat(List<E> list) {
    return new CustomListAssert<>(list);
  }

  public CustomListAssert(List<? extends E> actual) {
    super(actual);
  }

  public IntListAssert extractingInt(ToIntFunction<E> mapper) {
    return new IntListAssert(actual.stream()
      .mapToInt(mapper).boxed().collect(toList()));
  }    
}

public class IntListAssert extends ListAssert<Integer> {
  public IntListAssert(List<Integer> actual) {
    super(actual);
  }

  public IntListAssert allGreaterThan(int i) {
    allMatch(n -> n > i);
    return this;
  }
}