HashMap<Integer,String> map = new HashMap<> ();
for (int i=0;i<10;i++) {
  map.put (i, Integer.toString (i));
}
for (Integer key : map.keySet ()) {
  System.out.println (key);
}