Map<Integer, List<ClassName>> map = new LinkedHashMap<>();
map.put(1, Arrays.asList(new ClassName(100, 1.0), new ClassName(233, 0.9)));
map.put(2, Arrays.asList(new ClassName(24, 1.0), new ClassName(13, 0.92)));
map.put(3, Arrays.asList(new ClassName(5, 1000.0), new ClassName(84, 901.0)));
map.put(4, Arrays.asList(new ClassName(24, 900.0), new ClassName(12, 850.0)));
map.forEach((k, v) -> System.out.println(k + "=" + v));