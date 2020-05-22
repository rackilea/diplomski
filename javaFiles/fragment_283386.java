for(Map.Entry<Integer, Integer> entry : mB.entrySet()){
    Integer k = entry.getKey();
    Integer v = entry.getValue();
    if(!mA.containsKey(k)){
        l.add(k);
    }else if(mA.get(k).intValue() != v.intValue()){//This is the problem
        l.add(k);
    }
}