public void push(int a){
  if(top>=size){
    int array2[]=new int[size*2];
    for(int i=0;i<size;i++){
      array2[i]=array[i];
    }
    array = array2; 
    size *=2;
  }
  array[top++]=a;
}