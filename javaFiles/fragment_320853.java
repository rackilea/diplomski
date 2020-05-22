String storeId = "3501";
HashMap<String,String> hMap =  new HashMap<>();
hMap.put("01", "105");
hMap.put("02", "3501");
hMap.put("07", "3501");

List<String> matches = new ArrayList<>();

for (int mainLoop=0; mainLoop < 3 ;mainLoop++) {
    for (Map.Entry<String, String> map : hMap.entrySet()) {
        if (storeId.equalsIgnoreCase(map.getValue())) {
            matches.add(map.getKey());
        }
    }
}

matches.forEach(System.out::println);