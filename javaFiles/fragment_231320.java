//have a lock Object
private static final Object lock = new Object();
// your list
private static List list = null

//synchronized on lock object. this will allow only one thread at a time
synchronized(lock){
//access,add to, remove from list
}