Reader reader=new BufferedReader(new FileReader(new File("resources/json.txt")));

Type type = new TypeToken<Map<String, Map<String, String>>>() {}.getType();
Map<String, Map<String, String>> data = new Gson().fromJson(reader, type);

// pretty printing 
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(data));