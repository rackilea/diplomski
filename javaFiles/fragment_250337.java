List<Value> subset = new ArrayList<>();
Iterator<Value> iterator = list.iterator();
while (iterator.hasNext()) {
    Value val = iterator.next();
    if (valueMap.containsKey(val.getId())) {
        subset.add(val);
    }
}