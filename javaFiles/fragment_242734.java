Hashtable t = new Hashtable();

synchronized(t){
   if(!t.contains(object1) && !t.contains(object2)){
      t.put(object3,object3);
   }
}