synchronized  (object1) { // monitorenter for object1
        // code1
        synchronized (object1) { // monitorenter for object1
            //code2
        }
        //code3
    }