Map<Integer,Integer> map = new LinkedHashMap<>();

public void discount() {
    map.put(10000,20);
    map.put(5000,15);
    map.put(1000,10);

    System.out.println(discount(11000));
    System.out.println(discount(5100));
    System.out.println(discount(1100));
    System.out.println(discount(100));
}

private int discount(int value) {
    for (Map.Entry<Integer,Integer> entrySet : map.entrySet()) {
        if (value >= entrySet.getKey()) {
            return entrySet.getValue();
        }
    }
    return 0;
}