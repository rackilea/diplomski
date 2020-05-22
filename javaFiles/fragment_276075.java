public static void main(String args[]) {
    List<List<String>> listList = prepareTestData();
    Map<String, String> idNameMap = new HashMap<>();
    Map<String, String> managingRelationMap = new HashMap<>();
    List<String> theTop = new ArrayList<>();
    for (List<String> list : listList) {
        idNameMap.put(list.get(1), list.get(0));
        if (list.get(2) == null || list.get(2).equals(list.get(1))) { // no managing or managed by itself;
            theTop.add(list.get(1));
        } else {
            managingRelationMap.put(list.get(1), list.get(2));
        }
    }

    // add specials whose managing does not exist;
    for (String s : managingRelationMap.keySet()) {
        if (!idNameMap.containsKey(managingRelationMap.get(s))) {
            theTop.add(s);
        }
    }

    for (String top : theTop) {
        printManagingStructure(top, managingRelationMap, idNameMap, 1);
    }
}

private static List<List<String>> prepareTestData() {
    List<List<String>> listList = new ArrayList<>();
    listList.add(new ArrayList<>(Arrays.asList("Target", "002", "150")));
    listList.add(new ArrayList<>(Arrays.asList("Coles", "003", "150")));
    listList.add(new ArrayList<>(Arrays.asList("Wesfarmers", "150", "100")));
    listList.add(new ArrayList<>(Arrays.asList("Shell", "001", "150")));
    listList.add(new ArrayList<>(Arrays.asList("Max Company X", "100", null)));
    listList.add(new ArrayList<>(Arrays.asList("Woolworths Group", "250", "100")));
    listList.add(new ArrayList<>(Arrays.asList("Caltex", "201", "250")));
    listList.add(new ArrayList<>(Arrays.asList("Woolworths", "202", "250")));
    listList.add(new ArrayList<>(Arrays.asList("Aldi", "300", null)));
    listList.add(new ArrayList<>(Arrays.asList("PGX", "650", "600")));
    return listList;
}

private static void printManagingStructure(String managingId, Map<String, String> managingRelationMap,
                                           Map<String, String> idNameMap, int gapCount) {
    System.out.println(String.format("%" + gapCount * 20 + "s%-20s", "", idNameMap.get(managingId)));
    if (!managingRelationMap.containsValue(managingId)) {
        return;
    }
    managingRelationMap.entrySet().stream().filter(entry -> entry.getValue().equals(managingId))
            .forEach(entry -> {
                printManagingStructure(entry.getKey(), managingRelationMap, idNameMap, gapCount + 1);
            });
}