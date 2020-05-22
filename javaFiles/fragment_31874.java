Map map = new HashMap<String,List<String>>();

List<String> l1 = new ArrayList();

l1.add("HEllo");
l1.add("John");
l1.add("Michael");
l1.add("Jessy");

map.put("Names" , l1);

Intent intent = new Intent("CurrentActivityName".this, "DestinationActivityName".class);

intent.putExtra("Map",(Serializable) map);

startActivity(intent);