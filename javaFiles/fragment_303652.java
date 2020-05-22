Map<String, String> map =
    new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

while(resultSet.next()) {
    String weekName = resultSet.getString("WeekName");
    String tag = map.get(weekName);
    if(tag == null) {
        tag = "";
    }

    tag = tag + "<Event>";
    tag = tag + "<ID>" + resultSet.getString("EventID") + "</ID>";
    tag = tag + "<Desc>" + resultSet.getString("EventDesc") + "</D>";
    tag = tag + "</Event>";

    map.put(weekName, tag);
}

String sunTag = map.get("sunday");
String monTag = map.get("monday");
String tueTag = map.get("tuesday");
String wedTag = map.get("wednesday");
String thuTag = map.get("thursday");
String friTag = map.get("friday");
String satTag = map.get("saturday");