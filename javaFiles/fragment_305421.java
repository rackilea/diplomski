// This key should always appear at the end of the list.
public static final String AtEnd = "Always at the end";

// A sample map.
SortedMap<String, String> myMap =
        new TreeMap<>(
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return o1.equals(AtEnd) ? 1 : o2.equals(AtEnd) ? -1 : o1.compareTo(o2);
          }
        });

private void test() {
  myMap.put("Monday", "abc");
  myMap.put("Tuesday", "def");
  myMap.put("Wednesday", "ghi");
  myMap.put(AtEnd, "XYZ");

  System.out.println("myMap: "+myMap);
  // {Monday=abc, Tuesday=def, Wednesday=ghi, Always at the end=XYZ}
}