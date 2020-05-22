public void run() {
    init();
    while(true){
        if(!running) {
            Thread.sleep(1000);  //1 second or something else
            continue;
        }
        //Game logic here
    }
    stop();
}