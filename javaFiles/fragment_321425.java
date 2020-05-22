lock.lock();
try{
   ... do stuff 
   return true;
}finally{
   lock.unlock();
}