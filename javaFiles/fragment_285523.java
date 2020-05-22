List<Model> list= new ArrayList<Model>();
Map<Integer,Integer> convertedmap=new  HashMap<Integer,Integer>();

for(int i=0;i<list.size();i++){
Model model = list.get(i);

convertedmap.put(model.getId(),model.getCount());
}