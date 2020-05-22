1 public void enq (T element){
2 if (empty()){
3    head= new ListElement(element);
4    tail= head;
5  }else{

6   tail.nextElement=new ListElement(element);
7   tail=tail.nextElement;
  }