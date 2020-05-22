private static Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
private static List<String> nonDependentList = new ArrayList<String>();
private static Map<String, List<String>> dependentMap = new ConcurrentHashMap<String, List<String>>();

public static void main(String[] args) {

    List<String> list1 = new ArrayList<>();
    list1.add("string2");
    list1.add("STR_str2");
    list1.add("STR_str3");
    addRecord("STR_str1", list1);
    List<String> list2 = new ArrayList<>();
    list2.add("STR_xyz");
    list2.add("STR_ABC");
    addRecord("STR_str2", list2);
    List<String> list3 = new ArrayList<>();
    list3.add("Anukul");
    list3.add("mittal");
    addRecord("STR_str3", list3);
    List<String> list4 = new ArrayList<>();
    list4.add("Test");
    list4.add("STR_XYZ");
    addRecord("STR_ABC", list4);
    List<String> list5 = new ArrayList<>();
    list5.add("val");
    list5.add("var");
    addRecord("STR_XYZ", list5);
    List<String> list6 = new ArrayList<>();
    list6.add("val6");
    list6.add("valtest");
    addRecord("STR_free", list6);
    List<String> list7 = new ArrayList<>();
    list7.add("val6");
    list7.add("STR_free");
    addRecord("STR_7", list7);

    Map<String, List<String>> processedMap = proceedAndFetchRecords();
    System.out.println("Final result");
    for (Entry<String, List<String>> entry : processedMap.entrySet()) {
        System.out.println("Key : " + entry.getKey() + " || Values : " + entry.getValue());
    }
}

private static Map<String, List<String>> proceedAndFetchRecords() {
    for (Entry<String, List<String>> entry : map.entrySet()) {
        boolean flag = isNotDependent(entry.getValue());
        // System.out.println("Key : " + entry.getKey() + " isNotDependent :
        // " + flag);
        if (flag) {
            nonDependentList.add(entry.getKey());
        } else {
            List<String> list = getOnlyDependentList(entry.getValue());
            dependentMap.put(entry.getKey(), list);
        }
    }
    // showDependentMap();
    refreshDependentMap();

    // Final result
    Map<String, List<String>> processedMap = addResultsInMap();
    return processedMap;
}

private static void refreshDependentMap() {
    for (Entry<String, List<String>> entry : dependentMap.entrySet()) {
        List<String> list = entry.getValue();
        list.removeAll(nonDependentList);

        boolean flag = isNotDependent(list);

        if (flag) {
            nonDependentList.add(entry.getKey());
            dependentMap.remove(entry.getKey());
            refreshDependentMap();
        } else {
            continue;
        }
    }

}

private static Map<String, List<String>> addResultsInMap() {
    Map<String, List<String>> processedMap = new LinkedHashMap<String, List<String>>();

    for (String key : nonDependentList) {
        processedMap.put(key, map.get(key));
    }

    for (Entry<String, List<String>> entry : dependentMap.entrySet()) {
        processedMap.put(entry.getKey(), map.get(entry.getKey()));
    }
    return processedMap;
}

private static boolean isNotDependent(List<String> list) {
    int count = 0;
    for (String string : list) {
        if (!string.startsWith("STR_")) {
            ++count;
        }
    }
    if (list.size() == count) {
        return true;
    }
    return false;
}

private static void addRecord(String structureName, List<String> list) {
    map.put(structureName, list);
}

private static List<String> getOnlyDependentList(List<String> list) {
    List<String> list1 = new ArrayList<>();
    for (String string : list) {
        if (string.startsWith("STR_")) {
            list1.add(string);
        }
    }
    return list1;
}}