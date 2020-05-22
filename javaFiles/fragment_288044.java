String jsonArray = "[[\"22-1-2017;10:00-19:00\"],[\"22-1-2017;10:00-19:00\"]]";

Type listType = new TypeToken<List<List<String>>>(){}.getType();
List<List<String>> list = new Gson().fromJson(jsonArray, listType);

System.out.println(list);