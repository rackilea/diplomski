HashMap<Integer, String> map = new HashMap<Integer, String>();
map.put (1, "Mark");
map.put (2, "Tarryn");
List<String> list = new ArrayList<String>(map.values());
for (String s : list) {
    System.out.println(s);
}