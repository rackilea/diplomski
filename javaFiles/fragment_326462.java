synchronized  (object1) { // monitorenter for object1
    // code1
    synchronized (object2) { // monitorenter for object2
        //code2
    }
    //code3
}