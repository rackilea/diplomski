for (Map<Long, String> map : list) {
  for (Entry<Long, String> entry : map.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
  }
}