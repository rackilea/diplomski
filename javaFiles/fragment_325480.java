@Override public Lock readLock() {
     final ReadCounts myReadLocks = (ReadCounts) readLocksHeldByThread.get();
     return new Lock(){
        Lock l = super.readLock(); 
        public void lock(){
            l.lock();
            ++myReadLocks.value;
        }

        public void lockInterruptibly() throws InterruptedException{
            l.lockInterruptibly();
            ++myReadLocks.value;
        }

        public boolean tryLock(){
            if(l.tryLock()){
                ++myReadLocks.value;
                return true;
            }else return false;
        }

        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException{
            if(l.tryLock(time,unit)){
                ++myReadLocks.value;
                return true;
            }else return false;
        }

        public void unlock(){
            --myReadLocks.value;
            l.unlock();
        }

        public Condition newCondition(){
            return l.newCondition();
        }

     }
}