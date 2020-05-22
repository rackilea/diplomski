List cleanList = new ArrayList<Integer>();
for(int n=0;n<list.size();n++){

  if(!cleanList.contains(list.get(n))){
    cleanList.add(list.get(n));
  }else{
    cleanList.remove(list.get(n));
  }
}