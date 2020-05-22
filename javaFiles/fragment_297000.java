TreeMap <String, List<String>> department = new TreeMap<>();
department.put("AB", Arrays.asList("Bob", "Truus", "Miep"));
department.put("CD", Arrays.asList("Jan", "Kees", "Huub"));
department.put("EF", Arrays.asList("Jan", "Piet", "Bert"));
String aValue = "Jan";

Map<String,List<String>> result = department.entrySet().stream()
// filter out those departments that don't contain aValue
  .filter(entry -> entry.getValue().contains(aValue))
// collect the matching departments back into a map 
  .collect(Collectors.toMap(k -> k.getKey(), k -> k.getValue()));

// print the result
result.forEach((k,v)-> System.out.println(k + " " + v.toString()));