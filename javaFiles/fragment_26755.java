Map<Integer, MyObject> temp = new HashMap<Integer, MyObject>();
for (MyObject obj:firstList) {
   temp.put(obj.getId(), obj);
}
for (MyObject obj:secondList) {
   temp.put(obj.getId(), obj);
}
List<MyObject> result = new ArrayList<MyObject>(temp.values());