List<Integer> list = intMap.get(someKey);
if (list == null) {
    list = new ArrayList<>();
    intMap.put(someKey, list);
}
list.add(someValue);