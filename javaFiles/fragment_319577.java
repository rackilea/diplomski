public static Odp nearest(Odp o, NavigableSet<? extends Odp> set) {
  Odp f = set.floor(o), c = set.ceiling(o);
  if (f == null)
    return c;
  if (c == null)
    return f;
  int df = compareOdp(o, f), dc = compareOdp(c, o);
  return (df <= dc) ? f : c;
}