public static void main(String[] args) {
    Comparator<Foo> fooComparator = new Comparator<Foo>() {
        @Override
        public int compare(Foo o1, Foo o2) {
            return o1.compareTo(o2);
        }
    };

    TreeMap<Foo, String> map = new TreeMap<Foo, String>(fooComparator);

    map.put(new Foo(1, 4), "");
    map.put(new Foo(1, 3), "");
    map.put(new Foo(2, 4), "");
    map.put(new Foo(3, 4), "");
    map.put(new Foo(8, 10), "");
    map.put(new Foo(8, 17), "");
    map.put(new Foo(10, 10), "");

    int a = 2;
    int b = 5;

    for (Foo f : getKeysInRange(map, a, b)) {
        System.out.println(f);
    }
}

public static List<Foo> getKeysInRange(TreeMap<Foo, String> map, int low, int high) {
    Foo key1 = new Foo(low, low);
    Foo key2 = new Foo(high, high);

    Foo fromKey = map.ceilingKey(key1);
    Foo toKey = map.floorKey(key2);

    if (fromKey != null && toKey != null && fromKey.compareTo(toKey) < 0)
        return new ArrayList<Foo>(map.subMap(fromKey, true, toKey, true).keySet());
    return new ArrayList<Foo>();
}

public static class Foo implements Comparable<Foo> {
    private int i;
    private int j;

    private Foo(int i, int j) {
        super();
        this.i = i;
        this.j = j;
    }

    public int min() {
        if (i < j)
            return i;
        else
            return j;
    }

    public int max() {
        if (i > j)
            return i;
        else
            return j;
    }

    @Override
    public String toString() {
        return "I=" + i + "J=" + j;
    }

    @Override
    public int compareTo(Foo o) {
        if (this.min() > o.min()) {
            return 1;
        } else if (this.min() < o.min())
            return -1;
        else {
            if (this.max() > o.max())
                return 1;
            else if (this.max() < o.max())
                return -1;
            else
                return 0;
        }
    }
}