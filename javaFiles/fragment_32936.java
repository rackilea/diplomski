String[] cols = { COL1, COL2, COL3, COL4, "pp", //
        COL5, COL6, COL7, COL8, COL9, "STATE", COL10 };
List<String> data = new ArrayList<>();
Map<Integer, Map<String, String>> mapMap = new HashMap<>();
int index = 0;
while (rset.next()) {
    Map<String, String> dataMap = new HashMap<>();
    for (String c : cols) {
        String s = rset.getString(c);
        dataMap.put(c, s);
        data.add(s);
    }
    mapMap.put(index, dataMap);
    index++;
}