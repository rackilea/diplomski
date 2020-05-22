public static void main(String[] args) {
    Gson gson = new Gson();

    JsonTest test = new JsonTest("naveen", 20, 20000);
    JsonTest test2 = new JsonTest("parveen", 20, 20000);
    JsonTest test3 = new JsonTest("pawan", 20, 20000);
    JsonTest test4 = new JsonTest("anil", 20, 20000);

    List<JsonTest> list = new ArrayList<JsonTest>();
    list.add(test);
    list.add(test2);
    list.add(test3);
    list.add(test4);

    ListRow<JsonTest> dataList = new ListRow<JsonTest>(2, 2, list);

    Type type = new TypeToken<ListRow<JsonTest>>() {}.getType();

    System.out.println(gson.toJson(dataList, type));
}