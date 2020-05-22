List<CustomObject> a = Arrays.asList(
        new CustomObject(6),
        new CustomObject(3),
        new CustomObject(2),
        new CustomObject(5),
        new CustomObject(4),
        new CustomObject(1)
    );
    System.out.println(a);
    int[] b = {4, 6, 5, 3, 1, 2};
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < b.length; ++i)
        map.put(b[i], i);
    // for Java8
    // Collections.sort(a, (l, r) -> map.get(l.id) - map.get(r.id));
    Collections.sort(a, new Comparator<CustomObject>() {
        @Override
        public int compare(CustomObject l, CustomObject r) {
            return map.get(l.id) - map.get(r.id);
        }
    });
    System.out.println(a);