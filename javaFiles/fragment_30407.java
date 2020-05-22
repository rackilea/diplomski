public <E> E[] map(E[] array, Function<E> func) {
  E e = array[0];
  E res = func.call(e);
  array[0] = res;
  return array;
}