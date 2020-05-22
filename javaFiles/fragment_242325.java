Map<Integer, Integer> listInfo = new HashMap<>();
listInfo.put(1, 23);
listInfo.put(2, 45);
Integer valueToBeAdded = 42;
System.out.println("listInfo = " + listInfo);
if (listInfo.containsKey(1)) {
    if (listInfo.get(1) < valueToBeAdded) {
        listInfo.put(1, valueToBeAdded);
    }
} else {
    listInfo.put(1, valueToBeAdded);
}
System.out.println("listInfo = " + listInfo);