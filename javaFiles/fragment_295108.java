List<String> djikstaList = new ArrayList<String>();
for(String key : samling.keySet()){
    if(samling.get(key).getNode()!=från){
        System.out.println(samling.get(key).getNode());
        djikstaList.add(samling.get(key).getNode());
    }       
}