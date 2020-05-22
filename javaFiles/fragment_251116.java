Class1.foo() {
    synchronized(lock) {
        while(condition) { 
            try {
                lock.wait();
            }
        }
        lock.notify();
    }
}

Class1.foo() {
    synchronized(lock) {
    // >> inline from Class2.bar(Object lock) {
    //    where lock evaluates to the same object
        while(condition) {
            try {
                lock.wait();
            }
        }
        lock.notify();
    // << end inline }
   }
}