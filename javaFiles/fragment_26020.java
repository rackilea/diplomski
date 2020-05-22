class Pair {

    private final String key;
    private int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}

class Pairs {

    private static final Random RND = new Random();
    private List<String> list =  new ArrayList<>();
    private Map<String, Pair> map = new HashMap<>();

    public void addPair(String key, int value) {
        list.add(key);
        map.put(key, new Pair(key, value));
    }

    public Pair getPair(String key) {
        return map.get(key);
    }

    public Pair getRandomPair() {
        return map.get(list.get(RND.nextInt(list.size())));
    }
}