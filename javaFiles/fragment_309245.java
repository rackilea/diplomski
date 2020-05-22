Map<Integer,Integer> finalMap=new HashMap<Integer,Integer>();
for(A a:newList){
    if(finalMap.get(a.getId())!=null){
    finalMap.put(a.getId(),finalMap.get(a.getId())>a.getWeight()?finalMap.get(a.getId()):a.getWeight());
    }
    finalMap.put(a.getId(), a.getWeight());
}