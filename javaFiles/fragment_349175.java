HashMap<Key, ClassB> myMap = new HashMap<>();
for(ClassA instanceA: classAList) {
    Key key=Key.key(instanceA);
    if(myMap.containsKey(key)) {
        myMap.get(key).appendFieldA(instanceA.getFieldA());
    } else {
        myMap.put(key, new ClassB(instanceA));
    }
}