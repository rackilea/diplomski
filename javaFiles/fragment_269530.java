private Thread invul;

if(collision && (invul==null || !invul.isAlive())){
    player.health--;
    invul=new Thread(){
        public void run(){
            Thread.sleep(3000);
        }
    };
    invul.start();
}