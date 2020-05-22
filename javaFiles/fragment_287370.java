Main.java:14: error: method sort in class Main cannot be applied to given types;
        sort(list);
        ^
  required: List<? extends T>
  found: List<Date>
  reason: inferred type does not conform to declared bound(s)
    inferred: Date
    bound(s): Comparable<Date>
  where T is a type-variable:
    T extends Comparable<T> declared in method <T>sort(List<? extends T>)
1 error