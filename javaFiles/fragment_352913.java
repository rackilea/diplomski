List<String> valuesSet = new ArrayList<String>();
for (int i = 0; i < values1.size(); i++) {
    String value1 = StringEscapeUtils.escapeSql(values1.get(i).toString());
    String value2 = StringEscapeUtils.escapeSql(values2.get(i).toString());

    valuesSet.add(value1 + "," + value2;
}