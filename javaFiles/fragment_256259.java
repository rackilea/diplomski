Map<String,List<X>> map = new HashMap<>();
    for(X item : items){
        if(!map.containsKey(item.getBrand())){
            map.put(item.getBrand(), new ArrayList<>());
        }else{
            map.get(item.getBrand()).add(item);
        }
    }
    List<X> result = new ArrayList<>();
    for(Map.Entry<String,List<X>> e : map.entrySet()){
        result.add(e.getValue().get(0));
    }