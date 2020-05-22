Map<Integer,YourClass> map = new HashMap<>();
map.put(objectOfYourClassWithID1.getID(),objectOfYourClassWithID1);
map.put(objectOfYourClassWithID2.getID(),objectOfYourClassWithID2);
if (map.containsKey(2)) {
    map.get(2).setSomeProperty(newValue); // this will only change the object whose ID is 2
}