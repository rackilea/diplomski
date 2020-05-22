public static HashSet<String> getEnums() {

  HashSet<String> values = new HashSet<String>();

  for (Choice c : Choice.values()) {
      values.add(c.name());
  }

  return values;
}