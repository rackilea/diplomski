public MapDifference<String, Object> getMapDifference(String jsonString1, String jsonString2) {
    MapDifference<String, Object> mapDifference = null;
    Gson gson = new Gson();
    Type mapType = new TypeToken<Map<String, Object>>() {
    }.getType();
    Map<String, Object> firstMap = gson.fromJson(jsonString1, mapType);
    Map<String, Object> secondMap = gson.fromJson(jsonString2, mapType);
    firstMap = CollectionUtils.isEmpty(firstMap) ? new HashMap<>() : firstMap;
    secondMap = CollectionUtils.isEmpty(secondMap) ? new HashMap<>() : secondMap;
    //This contains the List of keys that is required to be filtered out from Json Strings before comparision like {"message", "objects.desc"}
    List<String> firstIgnoreList = getIgnoreList1();
    List<String> secondIgnoreList = getIgnoreList2();

    filterKeys(firstMap, firstIgnoreList);
    filterKeys(secondMap, secondIgnoreList);

    mapDifference = Maps.difference(firstMap, secondMap);
    return mapDifference;
  }


private void filterKeys(Map<String, Object> keyMap, List<String> ignoreList) {
    if (!(CollectionUtils.isEmpty(keyMap) || CollectionUtils.isEmpty(ignoreList))) {
        ignoreList.stream().parallel().forEach(key -> recursiveRemove(keyMap, key));
    }
  }

private static void recursiveRemove(Map<String, Object> keyMap, String key) {
    List<String> path = Arrays.asList(StringUtils.split(key.trim(), "."));
    int size = path.size();
    int index = 0;
    List<LinkedTreeMap> treeMapList = new ArrayList<LinkedTreeMap>();
    treeMapList.add((LinkedTreeMap) keyMap);
    while (index != size - 1) {
      int i = index++;
      List<LinkedTreeMap> treeMapListTemp = new ArrayList<LinkedTreeMap>();
      treeMapList.stream().parallel().forEach(treeMap -> {
        Object obj = treeMap.get(path.get(i));
        if (obj instanceof List) {
          treeMapListTemp.addAll((List<LinkedTreeMap>) obj);
        } else if (obj instanceof LinkedTreeMap) {
          treeMapListTemp.add((LinkedTreeMap) obj);
        }
      });
      treeMapList = treeMapListTemp;
    }
    treeMapList.stream().parallel().forEach(treeMap -> treeMap.remove(path.get(size - 1)));
  }