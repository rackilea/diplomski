List<String> copyArr = testMap.get(id);
if (copyArr == null) {
    copyArr = new CopyOnWriteArrayList<String>();
    List<String> inMap = testMap.putIfAbsent(id, copyArr);
    if (inMap != null) copyArr = inMap; // already in map
}
copyArr.add("Add Value");