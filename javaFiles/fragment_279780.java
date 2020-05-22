Object lock = new Object(); 
public void anyConcurrentFunction(){
   synchronized(lock){
   do something here...
  }
}