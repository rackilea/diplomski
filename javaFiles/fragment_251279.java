Map<String, long[]> map = new ConcurrentSkipListMap<>();
map.put("A", new long[2]);
IntStream.range(0, 1_000_000)
        .parallel()
        .forEach(i -> map.compute("A", (k, v) -> {
            v[0]++;
            v[1]++;
            return v;
        }));
System.out.println(Arrays.toString(map.get("A")));