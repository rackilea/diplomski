Map<String, Integer> map = new LinkedHashMap<String, Integer>();
map.put("Audi", 3);
map.put("BMW", 5);
map.put("Vauxhall", 7);

List<String> indexes = new ArrayList<String>(map.keySet()); // <== Set to List

// BOOM !

System.out.println(indexes.indexOf("Audi"));     // ==> 0
System.out.println(indexes.indexOf("BMW"));      // ==> 1
System.out.println(indexes.indexOf("Vauxhall")); // ==> 2