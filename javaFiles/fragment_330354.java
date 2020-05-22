private static class Tuple implements Comparable<Tuple> {
    private int count;
    private String word;

    public Tuple(int count, String word) {
        this.count = count;
        this.word = word;
    }

    @Override
    public int compareTo(Tuple o) {
        return new Integer(this.count).compareTo(o.count);
    }
    public String toString() {
        return word + " " + count;
    }
}

public static void main(String[] args) {
    String[] words = { "the", "he", "he", "he", "he", "he", "he", "he",
            "he", "the", "the", "with", "with", "with", "with", "with",
            "with", "with" };
    // find frequencies
    Arrays.sort(words);
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String s : words) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }
    List<Tuple> al = new ArrayList<Tuple>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        al.add(new Tuple(entry.getValue(), entry.getKey()));
    }
    Collections.sort(al);
    System.out.println(al);
}