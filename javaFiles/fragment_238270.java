void timer(int seconds)throws InterruptedException{
    for(int i = 0; i < seconds; i++){
        Thread.sleep(1000);
        //Output whatever message you want to appear every second. The variable 'i' will hold the current second in the countdown.
    }
}