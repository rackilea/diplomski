for (Entry<Integer, Set<String>> e : myMap.entrySet()) {
  if (e.getValue().size() > 1) {
    System.out.println(e.getKey());
    for (String s : e.getValue()) {
      System.out.println("    " + s);
    }
  }
}