public Object[] toArray(){
  int s=size();
  Object[] result=new Object[s];
  Node n=first;
  for (int i=0; i<s; i++){
     result[i]=n.data;
     n=n.next;
  }
  return result;
}