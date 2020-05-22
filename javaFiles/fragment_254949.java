Map<String, List<String>> map = new HashMap<String, List<String>>();
map.put("jack", Array.asList("blue", "orange", "green", "purple"));
map.put("blue", Array.asList("yellow", "red"));
map.put("yellow", Array.asList("sky", "wind", "earth"));
map.put("orange", Array.asList("char1", "char2", "char3"));

List<String> results = new ArrayList<String>();
for (String s : map.get("jack")) {
    if (map.get(s) != null) {
        for (String s2 : map.get(s)) { results.add(s2); }
    }    
}