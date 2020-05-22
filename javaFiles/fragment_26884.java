private static volatile boolean shouldStop=false;

public void run() {
    try{
        while (true) {
            if (someCondition) {
                // quit other threads when they call await()
                return;
            }
            try{
                if(shouldStop)return;
                barrier.await();
            }catch(BrokenBarrierException e){
                //someone stopped 
                return;
            }
       }
   }finally{
       shouldStop =true;
       barrier.reset();
   }
}