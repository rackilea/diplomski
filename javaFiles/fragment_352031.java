check(T element) {
  if (element.getClass().equals(SomeType.class)) {
    check((SomeType) element);
  } elseif (element.getClass().equals(SomeOtherType.class)) {
    check((SomeOtherType) element);
  }