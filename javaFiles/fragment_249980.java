ReentrantLock [] locks = new ReentrantLock[nb];
// fill the array of ReentranLock, one per cell

locks[cellRank].lock();
try {
   // your stuff
} finally {
  lock[cellRank].unlock();
}