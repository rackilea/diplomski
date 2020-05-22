public void run() {
    while(true){
        if((int)point.getX() > player.getX()){
            while((int)point.getX() > player.getX()){
                player.moveX(1);
            }
        }
        sleep(20 /* ms */);
    }
}