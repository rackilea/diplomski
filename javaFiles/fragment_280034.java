synchronized(lock) {
         while (!someCondition) {
             lock.wait();
         }
    }
    // ...