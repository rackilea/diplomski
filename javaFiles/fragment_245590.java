long lastSec = 0;
while(true){
    long sec = System.currentTimeMillis() / 1000;
    if (sec != lastSec) {
       //code to run
       lastSec = sec;
    }//If():
}//While