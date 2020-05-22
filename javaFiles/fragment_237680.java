List<String> x = new ArrayList<>();
Map<String, List<String>> map = new HashMap<>();

List<String> x1 = new ArrayList<>(x);

map.put("test", x1);