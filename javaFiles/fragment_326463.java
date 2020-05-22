synchronized  (object2) { // monitorenter for object2
        // code2.1
        synchronized (object1) { // monitorenter for object1
           //code2.2
        }
       //code2.3
    }