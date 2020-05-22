ArrayList<String> result = new ArrayList<>();
for(int i=0;i<list.size();i++){
    if(list.get(i).length()==maxS){
       result.add(list.get(i));
       System.out.println(list.get(i));
    }
}