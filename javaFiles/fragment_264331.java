public void foo() {
     MyClass obj = new MyClass();
     pq.add(obj);
     synchronized(obj) {
         while (!obj.isDoneBeingProcessed()) {
             obj.wait();
         }
      }
 }

 public void bar() {
      MyClass next = pq.remove();
      if (!next) {
          return;
      }
      next.doProcessing();
      synchronized(next) {
          next.setDone(true);
          next.notifyAll();
      }
 }