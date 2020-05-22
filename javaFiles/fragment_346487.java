//Thread1 enters here
synchronized(x){
     while(x.count < 4) {
         //condition is judged true and thread1 is about to wait 
         //..but..ohh!! Thread2 is prioritized just now !
         //Thread2, acting on notify block side, notices that with its current count incrementation, 
         //count increases to 4 and therefore a notify is sent.... 
         //but...but x is expected to wait now !!! for nothing maybe indefinitely !
       x.wait();
       //maybe block here indefinitely waiting for a notify that already occurred!
     }
}