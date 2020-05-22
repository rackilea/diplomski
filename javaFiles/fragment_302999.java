while(true){
    synchronized (myArrayList) {
        if(myArrayList.size() > 0){
            //do stuff
        }
    }
    //sleep(...) // outside the lock!
}