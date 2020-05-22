List<Value> subset = new ArrayList<>();
for (Value val : list) {
    if (valueMap.containsKey(val.getId())) {
        subset.add(val);
    }
}