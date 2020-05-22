List<String> myList = new ArrayList<String>();
// no identical Strings here
Set<String> mySet = new LinkedHashSet<String>();
myList.add("Cat"); // index 0
myList.add("Dog"); // index 1
myList.add("Cow"); // etc
myList.add("Cat");
myList.add("Rat");
mySet.add("Cat"); // index 0
mySet.add("Dog"); // index 1
mySet.add("Cow"); // etc
mySet.add("Cat"); // index 0 - already there
mySet.add("Rat");
Map<Integer, String> myMap = new HashMap<Integer, String>();
for (int i = 0; i < myList.size(); i++) {
    myMap.put(i, myList.get(i));
}
System.out.println(myMap);
Map<Integer, String> myOtherMap = new HashMap<Integer, String>();
int i = 0;
for (String animal: mySet) {
    myOtherMap.put(i++, animal);
}
System.out.println(myOtherMap);