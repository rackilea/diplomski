String jsonString="[{\"tag\":\"rat\",\"score\":0.7973},{\"tag\":\"lion\",\"score\":0.7184},{\"tag\":\"dog\",\"score\":0.2396},{\"tag\":\"woof\",\"score\":0.1944},{\"tag\":\"cat\",\"score\":0.1157}]";
Type type = new TypeToken<ArrayList<Map<String, String>>>() {}.getType();
ArrayList<Map<String, String>> data = new Gson().fromJson(jsonString, type);
for (Map<String, String> map : data) {
    System.out.println(map.get("tag"));
}