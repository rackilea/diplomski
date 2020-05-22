//declaring and initializing the list of maps
//line below works for Java 7
//List<Map<String, String>> listOfMaps = new ArrayList<>();
//if you want/need to use Java 6 then use the following
List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();

//declaring, initializing and filling a map
//line below works for Java 7
//Map<String, String> map1 = new HashMap<>();
//if you want/need to use Java 6 then use the following
Map<String, String> map1 = new HashMap<String, String>();
map1.put("name", "Luiggi");
map1.put("lastname", "Mendoza");
map1.put("maintag", "Java");

//declaring, initializing and filling another map
//line below works for Java 7
//Map<String, String> map2 = new HashMap<>();
//if you want/need to use Java 6 then use the following
Map<String, String> map2 = new HashMap<String, String>();
map2.put("name", "Foo");
map2.put("lastname", "Bar");
map2.put("maintag", "Scala"); //I have nothing against scala

//add maps into the list
listOfMaps.add(map1);
listOfMaps.add(map2);

//Show contents of the list and map
System.out.println(listOfMaps);

//Traverse each element of the List to access key and value
int index = 0;
//it is better to use Iterator or enhanced for each than using List#get(index)
for (Map<String, String> map : listOfMaps) {
    System.out.println("Printing element " + index++);
    for(Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    System.out.println("--------------------------");
}