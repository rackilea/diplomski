JSONObject jo = new JSONObject(jsData);
JSONArray table = getTable(jo);

Map<String, Map<String, String>> tableNames = getTableNames();
String totalRevenueKey = tableNames.get("Revenue").get("Total Revenue");
String[] totalRevenueValues = getRow(table, totalRevenueKey);
String value = totalRevenueValues[0];