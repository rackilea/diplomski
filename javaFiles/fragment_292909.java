while(stop) {
  synchronized(mutexobj) {
    while(!hashmap.containsKey(counter)) {
      wait();
    }
    hashmap.get(counter++);
  }
}