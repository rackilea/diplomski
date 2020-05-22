public void render(){
  synchronized(list){
    for(int i =0; i <list.size();i++){
      //....
    }
  }
}
public void update(Object element){
 synchronized(list){
  list.remove(element);  
 }
}