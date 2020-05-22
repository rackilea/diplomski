int mostFrequent(int... ary) {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();

    for (int a : ary) {
        Integer freq = m.get(a);
        m.put(a, (freq == null) ? 1 : freq + 1);
    }

    int max = -1;
    int mostFrequent = -1;

    for (Map.Entry<Integer, Integer> e : m.entrySet()) {
        if (e.getValue() > max) {
            mostFrequent = e.getKey();
            max = e.getValue();
        }
    }

    return mostFrequent;
}