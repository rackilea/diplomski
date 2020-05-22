myMap.devNameType.get('Key').remove('Value');

HashMap<String, ArrayList<String>> mMap = new HashMap<String, ArrayList<String>>();
ArrayList<String> listA = new ArrayList<String>();
ArrayList<String> listB = new ArrayList<String>();
ArrayList<String> listC = new ArrayList<String>();
ArrayList<String> listD = new ArrayList<String>();

listA.add("1");
listA.add("2");
listA.add("3");
listA.add("5");

mMap.put("A", listA);
mMap.put("B", listB);
mMap.put("C", listC);
mMap.put("D", listD);


myMap.get("A").remove("3");