class HotThrd extends Thread{
   HotThrd(String name){
      super(name);
   }
}

....
....
public long addHotThrd(int i) {
    HotThrd newThrd = new HotThrd("Thread"+i);
    hotThreadsMap.put(newThrd, newThrd.getId());        
    return newThrd.getId();
}