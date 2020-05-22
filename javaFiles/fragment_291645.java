static <T,E extends Enum<E>>
  EnumMap<E,T> funcToMap(Function<E,T> f, Class<E> t, E... values) {
    return Stream.of(values)
      .collect(Collectors.toMap(Function.identity(), f, (x,y)->x, ()-> new EnumMap<>(t)));
}
static <T,E1 extends Enum<E1>,E2 extends Enum<E2>>
  EnumMap<E1,EnumMap<E2,T>> biFuncToMap(
  BiFunction<E1,E2,T> f, Class<E1> t1, Class<E2> t2, E1[] values1, E2[] values2){

  return funcToMap(e1->funcToMap(e2->f.apply(e1, e2), t2, values2), t1, values1);
}