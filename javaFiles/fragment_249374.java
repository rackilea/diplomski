private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
static {
    map.put(1, 1);
    map.put(2, 2);
}

public static int countPossibilities(int n) {
    if (map.containsKey(n))
        return map.get(n);

    int a, b;

    if (map.containsKey(n - 1))
        a = map.get(n - 1);
    else {
        a = countPossibilities(n - 1);
        map.put(n - 1, a);
    }

    if (map.containsKey(n - 2))
        b = map.get(n - 2);
    else {
        b = countPossibilities(n - 2);
        map.put(n - 2, b);
    }

    return a + b;
}