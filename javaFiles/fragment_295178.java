Map<String, List<MyObject>> categoryMap = new HashMap<>();
for (MyObject o : objects) {
    String category = o.getCategory();
    List<MyObject> list = categoryMap.get(category);
    if (list == null) {
         list = new ArrayList<>();
         catgeoryMap.put(category, list);
    }
    list.add(o);
}