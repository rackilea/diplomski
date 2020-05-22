AtomicBoolean condition = ... // defined elsewhere

if(condition.get()){
    synchronized(myLock){
        // Critical segment
    }
}