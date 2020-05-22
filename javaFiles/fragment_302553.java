public void foo(){
    if(condition){
        synchronized(this){
            // Critical segment
        }
    }
}