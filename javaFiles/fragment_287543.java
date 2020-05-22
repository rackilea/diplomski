public static <T> List<T> filter(Collection<? extends T> source,
                                 Predicate<? super T> predicate)
{
  final List<T> result = new ArrayList<T>(source.size());
  for (T element: source)
    if (predicate.apply(element))
      result.add(element);
  return result;
}