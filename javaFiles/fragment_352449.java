DataFrame df = sqlContext.read().json(path);
String[] columnNames = df.columns;

DataFrame newDF = df.flatMap(row -> {
  ArrayList list = new ArrayList<>(columnNames.length);
  String id = (String)row.get(0);

  for (int i = 1; i < columnNames.length, i++) {
    list.add(id, columnNames[i], (int)row.get(i));
  }
  return list;
}).toDF("id", "item", "ranking");