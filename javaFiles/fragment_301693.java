Map<String, String> map = new HashMap<>();
    map.put("a", "");
    map.put("b", "");
    map.put("c", "");
    map.put("d", "");
    map.put("e", "");
    map.put("f", "");

    List<String> list = new ArrayList<String>(map.keySet());

    for (int i = 0; i < list.size() - 1; ++i) {
        String s = list.get(i);
        for (int j = i + 1; j < list.size(); ++j) {
            System.out.format("(%s, %s)%n", s, list.get(j));
        }
    }