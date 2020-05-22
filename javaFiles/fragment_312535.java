Map<String, List<MyClass>> hm = new HashMap<String, List<MyClass>>();
for(MyClass obj : OrignalList){
    if(null != hm.get(obj.Position)){
         String pos = obj.Position;
         hm.put(pos, hm.get(pos).add(obj));
    }else {
         List<MyClass> temp = new ArrayList<MyClass>();
         temp.add(obj);
         hm.put(obj.Position, temp);
    }
}