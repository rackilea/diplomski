public static void main(String[] args) {
    Hashtable<Integer, Pair> result = new Hashtable<Integer, Pair>();

    result.put(1, new Pair(1, 1 + 1));

    if (result.containsKey(1)) {
        Pair pair = result.get(1);
        System.out.println(pair.t);
        System.out.println(pair.u);
    }
}