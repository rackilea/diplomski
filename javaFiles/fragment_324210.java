Map<Integer, List<String>> hamap = new HashMap<Integer, List<String>>();

String[] columns = record.split(" ");
List<String> otherColumns = new ArrayList<String>();

for (int i=1; i < columns.length; i++) {
    otherColumns.add(columns[i]);
}

hamap.put(Integer.valueOf(columns[0]), otherColumns);

for(Map.Entry<Integer,List<String>> m :hamap.entrySet()) {
    System.out.println(m.getKey()+" "+m.getValue());
}