private int findIndex(Object item) {

  for(int i=0; i<data.length;i++){
    if(data[i] == item){
        return i;
    }
  }
  return -1;
}