synchronized(lock) {
    player p2 = new player(id,socket);
    Players.add(p2);
    id++;
    lock.notify();  
}