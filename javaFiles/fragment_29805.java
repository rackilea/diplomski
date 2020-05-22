while (iter.hasNext()) {
    MyObject obj = (MyObject) iter.next();
    String day = obj.getDate().format("YYYY-MM-DD");

    if(!map.containsKey(day)) {
       map.put(day, new ArrayList<MyObject>());
    }
    List<MyObject> list = map.get(day);
    list.add(obj);
    map.put(day, list);
}