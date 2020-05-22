List<Object> id = new ArrayList<Object>();

List<Item> newItem=new ArrayList<Item>();

//Do this on a button click or something maybe  
id.add(contFinalGrade.addItem()); 

//Create Items with those ids and get your property
for(int i=0;i<id.size();i++){
newItem.add(contFinalGrade.getItem(id.get(i)));

newItem.get(i).getItemProperty("parentCourseId");