Map<String, Integer> vec = new HashMap<>();
for (String token : tokens) {
  if (vocabulary.contains(token)) {
    vec.merge(token, 1, (old,v) -> old+v);
  }
}