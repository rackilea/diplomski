var.readLock().lock();
try{
    //...
}finally{
    var.readLock().unlock();
}