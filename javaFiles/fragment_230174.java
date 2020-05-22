public static HashSet<T> getAddedItems<T>(HashSet<T> before, HashSet<T> after)
{
  HashSet<T> out2 = new HashSet<T>(after);
  out2.RemoveWhere(x => before.Contains(x));
  return out2;
}