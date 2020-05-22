FileReader in = new FileReader(new File("resources/json3.txt"));
BufferedReader br = new BufferedReader(in);

// Convert JSON string into MAP object
Gson gson = new Gson();
Type type = new TypeToken<Map<String, ArrayList<Map<String, Map<String, Object>>>>>() {}.getType();
Map<String, ArrayList<Map<String, Map<String, Object>>>> map = gson.fromJson(br, type);

for (String key : map.keySet()) {
    System.out.println(key);
    for (Map<String, Map<String, Object>> value : map.get(key)) {
        for (String k : value.keySet()) {
            System.out.println(k);
            for (String k1 : value.get(k).keySet()) {
                System.out.println(k1 + ":" + value.get(k).get(k1));
            }
        }
        System.out.println("--------------");
    }
}

in.close();
br.close();