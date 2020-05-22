Lock rl = var.readLock();
rl.lock();
try{
    //...
}finally{
    rl.unlock();
}