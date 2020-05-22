String dateStr = "1987-11-19";
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
Date date = format.parse(dateStr);
// *********
String listStr = "[A,B,some text]";
String cut = listStr.substring(1, listStr.length - 2);
String[] array = cut.split(",");
List<String> list = new ArrayList<String>(Arrays.asList(array));