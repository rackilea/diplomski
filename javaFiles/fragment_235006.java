List<Map<String, String>> addressComponents = new ArrayList<Map<String, String>>();
Map<String, String> addressComponent1 = new HashMap<String, String>();
addressComponent1.put("long_name", "1600");
addressComponent1.put("short_name", "1600");
addressComponents.add(addressComponent1);
Map<String, String> addressComponent2 = new HashMap<String, String>();
addressComponent2.put("long_name", "Amphitheatre Pkwy");
addressComponent2.put("short_name", "Amphitheatre Pkwy");
addressComponents.add(addressComponent2);
// ...

List<Map<String, List<Map<String, String>>>> results = new ArrayList<Map<String, List<Map<String, String>>>>();
Map<String, List<Map<String, String>>> result1 = new HashMap<String, List<Map<String,String>>>();
result1.put("address_components", addressComponents);
results.add(result1);
// ...

Map<String, List<Map<String, List<Map<String, String>>>>> god = new HashMap<String, List<Map<String,List<Map<String,String>>>>>();
god.put("results", results);
String json = new Gson().toJson(god);
System.out.println(json); // There!