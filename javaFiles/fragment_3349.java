HashMap<String, List<String>> hashmap = new HashMap<String, List<String>>();

List<String> arraylist = new ArrayList<String>();
arraylist.add("Hello");
arraylist.add("World.");

//Put list to a group
hashmap.put("mykey", arraylist);

//Dynamically add element to a group
hashmap.get("mykey").add("Everyone");

//Retrieve all element of a group
List<String> list = hashmap.get("mykey");
System.out.println(list);