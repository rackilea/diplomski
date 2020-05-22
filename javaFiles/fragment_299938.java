public void methodA() {
     synchronized(lock1) {
      [...]
      values.get(0);
      }  
}

public void methodB() {
     synchronized(lock2) {
      [...]
      values.get(1);
      }  
}