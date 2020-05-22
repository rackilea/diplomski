/**
 * @param <F> The "from" type
 * @param <T> The "to" type
 */
interface Converter<F, T> {

  T to(F from);

  void update(T to, F from);
}

class BConvertImpl implements Converter<B, A> {

  A to(B from) { /* some impl */ }

  void update(A to, B from) { /* some impl */ }
}

class CConverterImpl implements Converter<C, A> {

  A to(C from) { /* some impl */ }

  void update(A to, C from) { /* some impl */ }
}