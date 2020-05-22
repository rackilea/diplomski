static void printWithDelay(int sec, String msg){
    int count = 0;
    long eventTime = System.nanoTime() + ((long)Math.pow(10, 9)*sec);
    while(count < 10){
        if(System.nanoTime() > eventTime){
            eventTime = System.nanoTime() + ((long)Math.pow(10, 9)*sec);
            System.out.println(msg + ": " + count++);
        }
    }
}