class MyHashMap<T> {
    int index = 0;
    HashMap<Integer, T> internalMap = new HashMap<>();

    public int add(T t) {
        int temp = index++;
        internalMap.put(temp, t);
        return temp;
    }
}