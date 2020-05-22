1 public void enq (T element){
2 if (empty()){
3    head= new ListElement(element);
4    tail= new ListElement(element);
  }

5 tail.nextElement=new ListElement(element);
6 tail=tail.nextElement;