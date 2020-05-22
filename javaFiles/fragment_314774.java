List<HashMap<String, String>> hashMapList = new LinkedList<HashMap<String, String>>();
HashMap<String, String> hashMap = new HashMap<String, String>();
hashMap.put("Ussain", "Bolt");
hashMapList.add(hashMap);

List<Map<String, String>> mapList = new LinkedList<Map<String, String>>();
for (HashMap<String, String> map : hashMapList) {
    mapList.add(map);
}