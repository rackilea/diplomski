private Map<String, List<MyObject>> getData() {
  Map<String, List<MyObject>> subTotalsByName = new HashMap<>();
  List<MyObject> objectList = dataBaseHelper.fetchData();

  for (MyObject obj : objectList) {
    List<MyObject> subTotalList = subTotalsByName.get(obj.name);
    if (subTotalList == null){
        subTotalList = new ArrayList<>();
        subTotalsByName.put(obj.name, subTotalList);
    }

    subTotalList.add(obj);
  }

  return subTotalsByName;
}