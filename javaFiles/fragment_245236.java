public static <T extends Matchable<T>> T findMatch(T toMatch, T[] toSearch) {
  if (toMatch == null)
    return null;

  Matchable<T> matchObj = toMatch;
  Class<?> matchClass = matchObj.getClass();

  for (T obj : toSearch) {
    if (matchClass.isInstance(obj) && matchObj.matches(obj))
      return obj;
  }

  return null;
}