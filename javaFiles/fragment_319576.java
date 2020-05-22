List<ResourceObject> newList=new ArrayList<ResourceObject>();

for(int i=0;i<originalList.size();i++){
    if(newList.contains(originalList.get(i))==false){
        newList.add(originalList.get(i));
    }
    else{
        for(int j=0;j<newList.size();j++){
            if(newList.get(j).equals(originalList.get(i))){
                int var=newList.get(j).getCount();
                int var1=var+originalList.get(i).getCount();
                newList.get(j).setCount(BigDecimal.valueOf(var1));
            }
        }
    }
}