@Scheduled(...)
public void process() {
    // Acquire the lock, wait forever until the lock owner t_B release the lock
    lock.lock();
    try {
      //do the job
    } finally {
       lock.unlock();
    }
}