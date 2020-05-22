List<String> a = ...;
Set<String> b = ...;

boolean result = new boolean[a.size()];
for (int i = 0; i < result.length; i++) {
  result[i] = b.contains(a);
}