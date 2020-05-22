public void m2(){
        lock.lock();
        try {
            System.out.println("m2");
            //after all the business logic is done
           m2done=true;
           methodM2finished.signalAll();
        } finally {
            lock.unlock();
        }
}