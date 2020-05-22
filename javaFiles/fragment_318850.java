ArrayList<Pair<String, String>> list = new ArrayList<>();
list.add(new Pair<>("ag1", "val1"));  list.add(new Pair<>("ag1", "val2"));
list.add(new Pair<>("ag1", "val4"));  list.add(new Pair<>("ag2", "val2"));       
list.add(new Pair<>("ag2", "val4"));  list.add(new Pair<>("ag3", "val2"));
list.add(new Pair<>("ag3", "val2"));  list.add(new Pair<>("ag3", "val3"));

List<String> arguments = list.stream().map(Pair::getKey).distinct().sorted().collect(Collectors.toList());
List<String> values = list.stream().map(Pair::getValue).distinct().sorted().collect(Collectors.toList());

short[][] res = new short[arguments.size()][values.size()];      

for(int ag = 0 ; ag<arguments.size() ; ag++){
    for(int val = 0 ; val<values.size() ; val++){  
        if(list.contains(new Pair<>(arguments.get(ag),values.get(val)))){
            res[ag][val] = 1;
        }else{
            res[ag][val] = 0;        
        }
    }    
}
System.out.println(Arrays.deepToString(res)); 
// [[1, 1, 0, 1], [0, 1, 0, 1], [0, 1, 1, 0]]