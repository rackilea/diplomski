Map<MyEnumType, Integer> sumMap = new EnumMap<MyEnumType, Integer>(MyEnumType.class);
for (MyEnumType e : MyEnumType.values()) {
    int sum = 0;
    for (Map<MyEnumType, Integer> map : maps) {
        sum += map.get(e); // you might want a null check here
    }
    sumMap.put(e, sum);
}