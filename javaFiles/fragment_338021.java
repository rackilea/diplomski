int size = currentTopicsDetailsList.size();
for(int i=0;i<size;i++) {
  Topic uT = updatedTopicsDetailsLIst.get(i);
  Topic cT = currentTopicsDetailsList.get(i);
  cT.update(uT); 
}