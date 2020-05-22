public static void main(String[] args) {

  Map<String, String> map = new HashMap<String, String>();
  map.put("abc", "abc");
  map.put("xyz", "xyz");
  map.put("ABC", "ABC");

  System.out.println(map);
}
Output
{ABC=ABC, abc=abc, xyz=xyz}