public static void main(String[] args) throws Exception {
    Map<String, Integer> counts = new HashMap<String, Integer>();
    int N = 10000000, n = 3;
    for (int i = 0; i < N; i++) {
        boolean[] word = buildRandomWellFormedWord(n);
        String str = toString(word);
        Integer count = counts.get(str);
        if (count == null)
            count = 0;
        counts.put(str, count + 1);
    }

    counts.entrySet().stream().forEach(e -> 
        System.out.println("P[" + e.getKey() + "] = " + e.getValue().doubleValue() / N));
}