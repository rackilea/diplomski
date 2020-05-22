public void m1(){
        lock.lock();
        try {
         while(!m2done){//wait till this flag becomes true
           try{
                methodM2finished.await();
              }
           catch(InterruptedException e){
               e.printStackTrace();
            }
         }
            System.out.println("m1");
        } finally {
            lock.unlock();
        }
}