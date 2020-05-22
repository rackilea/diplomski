ArrayList<Pair<String, String>> list = new ArrayList<>();
list.add(new Pair<>("ag1", "val1"));  list.add(new Pair<>("ag1", "val2"));
list.add(new Pair<>("ag1", "val4"));  list.add(new Pair<>("ag2", "val2"));
list.add(new Pair<>("ag2", "val4"));  list.add(new Pair<>("ag3", "val2"));
list.add(new Pair<>("ag3", "val2"));  list.add(new Pair<>("ag3", "val3"));

List<String> arguments = list.stream().map(Pair::getKey).distinct().collect(Collectors.toList());
List<String> values = list.stream().map(Pair::getValue).distinct().collect(Collectors.toList());

Map<String, Map<String,Integer>> map = new TreeMap<>();

for(String ag : arguments){
    map.putIfAbsent(ag, new TreeMap<>());

    for(String val : values){
        if(list.contains(new Pair<>(ag,val))){
            map.get(ag).put(val, 1);
        }else{
            map.get(ag).put(val,0);        
        }
    }

}
System.out.println(map);
//{ag1={val1=1, val2=1, val3=0, val4=1}, 
   ag2={val1=0, val2=1, val3=0, val4=1}, 
   ag3={val1=0, val2=1, val3=1, val4=0}}