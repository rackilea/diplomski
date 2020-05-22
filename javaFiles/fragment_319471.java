private <T> T nvlGet(T value, Supplier<T> second) {
  return value != null? value: second.get();
}
public Object a() {
  return nvlGet(super.a(), root::a);
}