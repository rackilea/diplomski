Map<String, List<Integer>> tm=new TreeMap<String, List<Integer>>();
String[] temp=folders.split(" |,");
for (int j=1;j<temp.length;j++){

    if (!tm.containsKey(temp[j])){
        tm.put(temp[j], new ArrayList<Integer>());
    }
    tm.get(temp[j]).add(j); // This will change the arraylist in the map.

}