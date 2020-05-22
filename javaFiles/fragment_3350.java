if (hashmap.containsKey("person")) {
  hashmap.get("person").add("Emdadul");
} else {
  List<String> lst = new ArrayList<String>();
  lst.add("Emdadul");
  hashmap.put("person", lst);
}