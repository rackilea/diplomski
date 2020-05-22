myMap.put(specificKey1, new ArrayList<Double>(Collections.nCopies(3, Double.valueOf(0))));
myMap.put(specificKey2, new ArrayList<Double>(Collections.nCopies(3, Double.valueOf(0))));
myMap.put(specificKey3, new ArrayList<Double>(Collections.nCopies(3, Double.valueOf(0))));
...
if (myMap.containsKey(specificKey1){
    myMap.get(specificKey1).set(0, someValue);
}